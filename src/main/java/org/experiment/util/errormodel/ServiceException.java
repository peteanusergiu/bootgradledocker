// Project:   Deutsche Telekom - SPICA
// Author:    Josef Adersberger <josef.adersberger@qaware.de>
// Copyright: QAware GmbH

package org.experiment.util.errormodel;

/**
 * Exception type for unexpected error situations inside SPICA services
 */
public class ServiceException extends CustomException {

    /**
     * The constructor with a message.
     *
     * @param message The message.
     */
    public ServiceException(String message) {
        super(DefaultErrorInfo.DEFAULT_SERVICE_EXCEPTION, message);
    }

    /**
     * The constructor with cause parameter ({@link Throwable}).
     *
     * @param cause the cause
     */
    public ServiceException(Throwable cause) {
        super(DefaultErrorInfo.DEFAULT_SERVICE_EXCEPTION, cause);
    }

    /**
     * The constructor with a message and the {@link Throwable} cause.
     *
     * @param message The message.
     * @param cause   The cause.
     */
    public ServiceException(String message, Throwable cause) {
        super(DefaultErrorInfo.DEFAULT_SERVICE_EXCEPTION, message, cause);
    }

    /**
     * The constructor with an {@link IErrorInfo} and the {@link Throwable} cause.
     *
     * @param errorInfo the {@link IErrorInfo}.
     * @param cause     The cause.
     */
    public ServiceException(IErrorInfo errorInfo, Throwable cause) {
        super(errorInfo, cause);
    }
}
