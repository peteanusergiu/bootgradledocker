package org.experiment.util.errormodel;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.experiment.lang.generic.ErrorDescription;
import org.experiment.util.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.xml.stream.XMLStreamException;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.experiment.util.errormodel.DefaultErrorInfo.*;

public final class ErrorDescriptionFactory {

    private ErrorDescriptionFactory() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(ErrorDescriptionFactory.class);

    private static final List<ErrorDescriber> ERROR_DESCRIBERS;

    // Default error describer, if no specific error describer can be found
    private static final ErrorDescriber DEFAULT_ERROR_DESCRIBER = new GenericErrorDescriber(DEFAULT_FRAMEWORK_EXCEPTION, Throwable.class);

    static {
        // Order is important, because JsonMappingException extends IOException
        ERROR_DESCRIBERS = new ArrayList<>();
        ERROR_DESCRIBERS.add(new EOFExceptionDescriber(BAD_REQUEST, EOFException.class));
        ERROR_DESCRIBERS.add(new ConstraintValidationExceptionDescriber(BAD_REQUEST, ConstraintViolationException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_REQUEST, JsonMappingException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_REQUEST, XMLStreamException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_BACKEND, PersistenceException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_BACKEND, IOException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_REQUEST, IllegalArgumentException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_REQUEST, InvocationTargetException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(SERVICE_NOT_FOUND, NoSuchRequestHandlingMethodException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(METHOD_NOT_ALLOWED, HttpRequestMethodNotSupportedException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(UNSUPPORTED_MEDIA_TYPE, HttpMediaTypeNotSupportedException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(NOT_ACCEPTABLE, HttpMediaTypeNotAcceptableException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_REQUEST, MissingServletRequestParameterException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_REQUEST, ServletRequestBindingException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(DEFAULT_FRAMEWORK_EXCEPTION, ConversionNotSupportedException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_REQUEST, TypeMismatchException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_REQUEST, HttpMessageNotReadableException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(DEFAULT_FRAMEWORK_EXCEPTION, HttpMessageNotWritableException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_REQUEST, MethodArgumentNotValidException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_REQUEST, MissingServletRequestPartException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_REQUEST, BindException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(SERVICE_NOT_FOUND, NoHandlerFoundException.class));
        ERROR_DESCRIBERS.add(new GenericErrorDescriber(BAD_AUTHORIZATION, AccessDeniedException.class));
    }

    private interface ErrorDescriber {
        /**
         * Returns an error description for a throwable.
         *
         * @param throwable         A subclass of Throwable.
         * @param includeStackTrace include stackTrace of the exception in the response
         * @return The an optional error description.
         */
        ErrorDescription createErrorDescription(Throwable throwable, boolean includeStackTrace);

        /**
         * Returns <code>true</code> if this <Code>ErrorDescriber</code> can handle the <Code>Throwable</code>.
         *
         * @param throwable A subclass of Throwable.
         * @return <code>true</code> if the implementation can handle the <code>Throwable</code>
         */
        boolean supports(Throwable throwable);
    }

    /**
     * Returns an error description for a throwable.
     *
     * @param throwable         A subclass of Throwable.
     * @param includeStackTrace include stackTrace of the exception in the response
     * @return The error description for the given throwable.
     */
    public static ErrorDescription fromThrowable(Throwable throwable, boolean includeStackTrace) {
        // Find first error describer, which supports the throwable
        Optional<ErrorDescriber> optionalErrorDescriber = ERROR_DESCRIBERS.stream().filter(e -> e.supports(throwable)).findFirst();
        // Use default error describer, if no specific error describer can be found
        ErrorDescriber errorDescriber = optionalErrorDescriber.orElse(DEFAULT_ERROR_DESCRIBER);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Error description creation attempt using " + errorDescriber.getClass().getName());
        }
        return errorDescriber.createErrorDescription(throwable, includeStackTrace);
    }

    /**
     * Returns an error description for a HTTP return code and error message.
     *
     * @param httpCode     The http return code
     * @param errorMessage The error message.
     * @return The error description for the given error information.
     */
    public static ErrorDescription fromHttpCode(int httpCode, String errorMessage) {
        DefaultErrorInfo errorInfo = DefaultErrorInfo.fromReturnCode(ReturnCode.fromHttpCode(httpCode));
        return new ErrorDescription(errorInfo.getReturnCode().getHttpCode(), errorInfo.getErrorId(),
                errorMessage, null);
    }

    private static class SpicaTroubleDescriber implements ErrorDescriber {

        private final Class<? extends Throwable> clazz;

        public SpicaTroubleDescriber(Class<? extends Throwable> clazz) {
            this.clazz = clazz;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ErrorDescription createErrorDescription(Throwable throwable, boolean includeStackTrace) {
            CustomTrouble spicaTrouble = (CustomTrouble) throwable;
            // handle spica exceptions
            return new ErrorDescription(spicaTrouble.getReturnCode().getHttpCode(), spicaTrouble.getErrorId(),
                    spicaTrouble.getMessage(), getStackTrace(spicaTrouble, includeStackTrace));
        }

        /**
         * Returns <code>true</code> if this <Code>ErrorDescriber</code> can handle the <Code>Throwable</code>.
         *
         * @param throwable A subclass of Throwable.
         * @return <code>true</code> if the implementation can handle the <code>Throwable</code>
         */
        @Override
        public boolean supports(Throwable throwable) {
            return clazz.isInstance(throwable);
        }
    }

    private static class GenericErrorDescriber implements ErrorDescriber {

        private final IErrorInfo errorInfo;
        private final Class<? extends Throwable> clazz;

        public GenericErrorDescriber(IErrorInfo errorInfo, Class<? extends Throwable> clazz) {
            this.errorInfo = errorInfo;
            this.clazz = clazz;
        }

        /**
         * {@inheritDoc}
         */
        public ErrorDescription createErrorDescription(Throwable exception, boolean includeStackTrace) {
            // handle spica exceptions
            return new ErrorDescription(this.errorInfo.getReturnCode().getHttpCode(), this.errorInfo.getErrorId(),
                    exception.getMessage(), getStackTrace(exception, includeStackTrace));
        }

        /**
         * Returns <code>true</code> if this <Code>ErrorDescriber</code> can handle the <Code>Throwable</code>.
         *
         * @param throwable A subclass of Throwable.
         * @return <code>true</code> if the implementation can handle the <code>Throwable</code>
         */
        @Override
        public boolean supports(Throwable throwable) {
            return clazz.isInstance(throwable);
        }
    }

    private static class EOFExceptionDescriber implements ErrorDescriber {

        private final IErrorInfo errorInfo;
        private final Class<? extends Throwable> clazz;

        public EOFExceptionDescriber(IErrorInfo errorInfo, Class<? extends Throwable> clazz) {
            this.errorInfo = errorInfo;
            this.clazz = clazz;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ErrorDescription createErrorDescription(Throwable throwable, boolean includeStackTrace) {
            return new ErrorDescription(this.errorInfo.getReturnCode().getHttpCode(),
                    this.errorInfo.getErrorId(), "No body content.", getStackTrace(throwable, includeStackTrace));
        }

        /**
         * Returns <code>true</code> if this <Code>ErrorDescriber</code> can handle the <Code>Throwable</code>.
         *
         * @param throwable A subclass of Throwable.
         * @return <code>true</code> if the implementation can handle the <code>Throwable</code>
         */
        @Override
        public boolean supports(Throwable throwable) {
            return clazz.isInstance(throwable);
        }
    }

    private static class SpicaExceptionDescriber implements ErrorDescriber {

        private final Class<? extends Throwable> clazz;

        public SpicaExceptionDescriber(Class<? extends Throwable> clazz) {
            this.clazz = clazz;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ErrorDescription createErrorDescription(Throwable throwable, boolean includeStackTrace) {
            CustomException spicaException = (CustomException) throwable;
            return new ErrorDescription(spicaException.getReturnCode().getHttpCode(), spicaException.getErrorId(),
                    spicaException.getMessage(), getStackTrace(spicaException, includeStackTrace));
        }

        /**
         * Returns <code>true</code> if this <Code>ErrorDescriber</code> can handle the <Code>Throwable</code>.
         *
         * @param throwable A subclass of Throwable.
         * @return <code>true</code> if the implementation can handle the <code>Throwable</code>
         */
        @Override
        public boolean supports(Throwable throwable) {
            return clazz.isInstance(throwable);
        }
    }

    private static class ConstraintValidationExceptionDescriber implements ErrorDescriber {

        private final IErrorInfo errorInfo;
        private final Class<? extends Throwable> clazz;

        public ConstraintValidationExceptionDescriber(IErrorInfo errorInfo, Class<? extends Throwable> clazz) {
            this.errorInfo = errorInfo;
            this.clazz = clazz;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ErrorDescription createErrorDescription(Throwable throwable, boolean includeStackTrace) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) throwable;
            return new ErrorDescription(this.errorInfo.getReturnCode().getHttpCode(),
                    this.errorInfo.getErrorId(),
                    buildViolationMessage(constraintViolationException.getConstraintViolations()),
                    getStackTrace(constraintViolationException, includeStackTrace));
        }

        private String buildViolationMessage(Set<ConstraintViolation<?>> constraintViolations) {
            StringBuilder buffer = new StringBuilder("Validation failed: ");
            for (ConstraintViolation constraintViolation : constraintViolations) {
                buffer.append("property: ").append(constraintViolation.getPropertyPath()).append("; value: '")
                        .append(constraintViolation.getInvalidValue()).append("; constraint: ")
                        .append(constraintViolation.getMessage()).append("'; ");
            }
            return buffer.toString();
        }

        /**
         * Returns <code>true</code> if this <Code>ErrorDescriber</code> can handle the <Code>Throwable</code>.
         *
         * @param throwable A subclass of Throwable.
         * @return <code>true</code> if the implementation can handle the <code>Throwable</code>
         */
        @Override
        public boolean supports(Throwable throwable) {
            return clazz.isInstance(throwable);
        }
    }

    private static String getStackTrace(Throwable throwable, boolean includeStackTrace) {
        if (includeStackTrace) {
            return ExceptionUtils.getStackTrace(throwable);
        } else {
            return null;
        }
    }
}
