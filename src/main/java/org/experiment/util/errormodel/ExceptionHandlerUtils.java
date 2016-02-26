package org.experiment.util.errormodel;

import javaslang.control.Try;
import org.experiment.lang.generic.BaseResponse;
import org.experiment.util.LoggingUtils;
import org.apache.commons.logging.Log;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.experiment.util.ResponseFactory.createResponseFromThrowable;
import static org.experiment.util.EnvironmentUtils.includeStackTraceInException;

public class ExceptionHandlerUtils {

    public static <T extends BaseResponse> ResponseEntity<T> tryWithRecovery(Try.CheckedSupplier<T> supplier, Class<T> responseClass, Environment environment, Log log) {
        return Try.of(supplier).map((value) -> ResponseEntity.ok(value))
                .recover(throwable -> handleThrowable(throwable, responseClass, environment, log)).get();
    }

    public static <T extends BaseResponse> ResponseEntity<T> handleThrowable(Throwable throwable, Class<T> responseClass, Environment environment, Log log) {
        T errorResponse = createResponseFromThrowable(responseClass, throwable, includeStackTraceInException(environment));
        HttpStatus status = mapHttpStatus(errorResponse.getError().getStatusCode());
        LoggingUtils.logException(log, null, throwable, status);
        return ResponseEntity.status(status).body(errorResponse);
    }


    public static <T extends BaseResponse> T tryWithRecoveryBasic(Try.CheckedSupplier<T> supplier, Class<T> responseClass, Environment environment, Log Log) {
        return Try.of(supplier).
                recover(throwable -> handleThrowableBasic(throwable, responseClass, environment, Log)).get();
    }

    public static <T extends BaseResponse> T handleThrowableBasic(Throwable throwable, Class<T> responseClass, Environment environment, Log log) {
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
                Log.warn(null, "Failed to map statusCode '" + statusCode +
                        "' to HttpStatus and returned 'INTERNAL_SERVER_ERROR' as HttpStatus", ex);

                */
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}

