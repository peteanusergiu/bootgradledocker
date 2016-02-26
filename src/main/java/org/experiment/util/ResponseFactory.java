package org.experiment.util;

import org.experiment.lang.generic.BaseResponse;
import org.experiment.util.errormodel.ErrorDescriptionFactory;

public final class ResponseFactory {

    private ResponseFactory() {
    }

    /**
     * Map a subclass of {@link Throwable} to a subclass of {@link BaseResponse}.
     *
     * @param responseClass     The response class which must be subclass of {@link BaseResponse}.
     * @param exception         The exception.
     * @param includeStackTrace include stackTrace of the exception in the response
     * @return a response mapped from the supplied exception.
     */
    public static <T extends BaseResponse> T createResponseFromThrowable(Class<T> responseClass, Throwable exception, boolean includeStackTrace) {
        T baseResponse = createResponse(responseClass);
        baseResponse.setError(ErrorDescriptionFactory.fromThrowable(exception, includeStackTrace));
        return baseResponse;
    }

    /**
     * Map a HTTP return code to a subclass of {@link BaseResponse}.
     *
     * @param responseClass The response class which must be subclass of {@link BaseResponse}.
     * @param httpCode      The http return code
     * @param errorMessage  The error message.
     * @return The {@link BaseResponse} instance.
     */
    public static <T extends BaseResponse> T createResponseFromHttpCode(Class<T> responseClass, int httpCode, String errorMessage) {
        T baseResponse = createResponse(responseClass);
        baseResponse.setError(ErrorDescriptionFactory.fromHttpCode(httpCode, errorMessage));
        return baseResponse;
    }

    private static <T extends BaseResponse> T createResponse(Class<T> responseClass) {
        try {
            return responseClass.newInstance();
        } catch (IllegalAccessException | InstantiationException exception) {
            throw new IllegalStateException(exception);
        }
    }
}

