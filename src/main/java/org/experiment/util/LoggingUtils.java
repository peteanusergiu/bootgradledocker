package org.experiment.util;

import org.apache.commons.logging.Log;
import org.experiment.util.usercontext.IRequestContext;
import org.springframework.http.HttpStatus;

public class LoggingUtils {

    public static void logException(Log logger, IRequestContext requestContext, Throwable exception, HttpStatus statusCode){
        if(statusCode.is4xxClientError()){
            logExceptionAsInfo(logger, requestContext, exception, statusCode);
        }else if(statusCode.is5xxServerError()){
            logExceptionAsWarning(logger, requestContext, exception, statusCode);
        }else{
            logExceptionAsWarning(logger, requestContext, exception, statusCode);
        }
    }

    public static void logExceptionWithMessage(Log logger, IRequestContext requestContext, String exception, String errorMessage, HttpStatus statusCode){
        if(statusCode.is4xxClientError()){
            logStringExceptionAsInfo(logger, requestContext, exception, errorMessage, statusCode);
        }else if(statusCode.is5xxServerError()){
            logStringExceptionAsWarning(logger, requestContext, exception, errorMessage, statusCode);
        }else{
            logStringExceptionAsWarning(logger, requestContext, exception, errorMessage, statusCode);
        }
    }

    private static void logExceptionAsError(Log logger, IRequestContext requestContext, Throwable exception, HttpStatus statusCode){
        String exceptionMessage = String.format("Exception handled: %s, Message: %s, HttpCode: %d", exception.getClass().getName(), exception.getMessage(), statusCode.value());
        logger.error(exceptionMessage, exception);
    }

    private static void logExceptionAsWarning(Log logger, IRequestContext requestContext, Throwable exception, HttpStatus statusCode){
        String exceptionMessage = String.format("Exception handled: %s, Message: %s, HttpCode: %d", exception.getClass().getName(), exception.getMessage(), statusCode.value());
        logger.warn( exceptionMessage, exception);
    }

    private static void logExceptionAsInfo(Log logger, IRequestContext requestContext, Throwable exception, HttpStatus statusCode){
        String exceptionMessage = String.format("Exception handled: %s, Message: %s, HttpCode: %d", exception.getClass().getName(), exception.getMessage(), statusCode.value());
        logger.info( exceptionMessage);
    }

    public static void logExceptionAsInfoWithUrl(Log logger, IRequestContext requestContext, Throwable exception, String errorUrl, HttpStatus statusCode){
        String exceptionMessage = String.format("Exception handled: %s, Message: %s, Path: %s, HttpCode: %d", exception.getClass().getName(), exception.getMessage(), errorUrl, statusCode.value());
        logger.info( exceptionMessage);
    }

    private static void logStringExceptionAsInfo(Log logger, IRequestContext requestContext, String exception, String errorMessage, HttpStatus statusCode){
        String exceptionMessage = String.format("Exception handled: %s, Message: %s, HttpCode: %d", exception, errorMessage, statusCode.value());
        logger.info( exceptionMessage);
    }

    public static void logStringExceptionAsInfoWithUrl(Log logger, IRequestContext requestContext, String exception, String errorMessage, String errorUrl, HttpStatus statusCode){
        String exceptionMessage = String.format("Exception handled: %s, Message: %s, Path: %s, HttpCode: %d,", exception, errorMessage, errorUrl, statusCode.value());
        logger.info( exceptionMessage);
    }

    private static void logStringExceptionAsError(Log logger, IRequestContext requestContext, String exception, String errorMessage, HttpStatus statusCode){
        String exceptionMessage = String.format("Exception handled: %s, Message: %s, HttpCode: %d", exception, errorMessage, statusCode.value());
        logger.error( exceptionMessage);
    }

    private static void logStringExceptionAsWarning(Log logger, IRequestContext requestContext, String exception, String errorMessage, HttpStatus statusCode) {
        String exceptionMessage = String.format("Exception handled: %s, Message: %s, HttpCode: %d", exception, errorMessage, statusCode.value());
        logger.warn( exceptionMessage);
    }
}
