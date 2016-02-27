package org.experiment.util.errormodel;

import javaslang.control.Try;
import org.apache.log4j.Logger;
import org.experiment.lang.generic.BaseResponse;
import org.experiment.util.LoggingUtils;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.experiment.util.EnvironmentUtils.includeStackTraceInException;
import static org.experiment.util.ResponseFactory.createResponseFromThrowable;

public class ExceptionHandlerUtils {

    public static <T extends BaseResponse> ResponseEntity<T> tryWithRecovery(Try.CheckedSupplier<T> supplier, Class<T> responseClass, Environment environment, Logger log) {
        return Try.of(supplier).map((value) -> ResponseEntity.ok(value))
                .recover(throwable -> handleThrowable(throwable, responseClass, environment, log)).get();
    }

    public static <T extends BaseResponse> ResponseEntity<T> handleThrowable(Throwable throwable, Class<T> responseClass, Environment environment, Logger log) {
        T errorResponse = createResponseFromThrowable(responseClass, throwable, includeStackTraceInException(environment));
        HttpStatus status = mapHttpStatus(errorResponse.getError().getStatusCode());
        LoggingUtils.logException(log, null, throwable, status);
        return ResponseEntity.status(status).body(errorResponse);
    }


    public static <T extends BaseResponse> T tryWithRecoveryBasic(Try.CheckedSupplier<T> supplier, Class<T> responseClass, Environment environment, Logger Logger) {
        return Try.of(supplier).
                recover(throwable -> handleThrowableBasic(throwable, responseClass, environment, Logger)).get();
    }

    public static <T extends BaseResponse> T handleThrowableBasic(Throwable throwable, Class<T> responseClass, Environment environment, Logger log) {
        T errorResponse = createResponseFromThrowable(responseClass, throwable, includeStackTraceInException(environment));
        HttpStatus status = mapHttpStatus(errorResponse.getError().getStatusCode());
        LoggingUtils.logException(log, null, throwable, status);
        return errorResponse;
    }

    public static HttpStatus mapHttpStatus(Integer statusCode) {
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode);
            } catch (Exception ex) {
                /*
                Logger.warn(null, "Failed to map statusCode '" + statusCode +
                        "' to HttpStatus and returned 'INTERNAL_SERVER_ERROR' as HttpStatus", ex);

                */
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}

