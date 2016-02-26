package org.experiment.util.errormodel;

import org.experiment.util.ReturnCode;

/**
 * Enumeration of the generic default errors defined by the SPICA language.
 *
 * If a service wants to define service-specific errors, it should define its own enumeration. Those errors
 * should <em>not</em> be added to this enumeration.
 */
public enum DefaultErrorInfo implements IErrorInfo {
    DEFAULT_SERVICE_EXCEPTION(ReturnCode.INTERNAL_SERVER_ERROR, "exception.service"),
    DEFAULT_FRAMEWORK_EXCEPTION(ReturnCode.INTERNAL_SERVER_ERROR, "exception.framework"),
    DEFAULT_UNKNOWN_EXCEPTION(ReturnCode.INTERNAL_SERVER_ERROR, "exception.unknown"),

    /**
     * Bad authentication: the user is not authenticated.
     * This is a temporary error and the client MAY repeat the request with suitable authentication.
     */
    BAD_AUTHENTICATION(ReturnCode.UNAUTHORIZED, "trouble.authentication"),

    /**
     * Bad authorization: the user is authenticated but not authorized to perform an action.
     * This is a permanent error and the request SHOULD NOT be repeated.
     */
    BAD_AUTHORIZATION(ReturnCode.FORBIDDEN, "trouble.authorization"),

    /**
     * Bad request: the request was malformed.
     * The client SHOULD NOT repeat the request without modifications.
     */
    BAD_REQUEST(ReturnCode.BAD_REQUEST, "trouble.request"),

    /**
     * Bad request: Resource not found
     * SPICA could not find the requested resource
     */
    RESOURCE_NOT_FOUND(ReturnCode.NOT_FOUND, "trouble.resource.notfound"),

    /**
     * Bad request: the request was malformed.
     * The client SHOULD NOT repeat the request without modifications.
     */
    REQUEST_TIMEOUT(ReturnCode.REQUEST_TIMEOUT, "trouble.request.timeout"),

    /**
     * Bad application: application failed to perform its operation.
     */
    BAD_APPLICATION(ReturnCode.INTERNAL_SERVER_ERROR, "trouble.app"),

    /**
     * Bad user: user is unknown.
     */
    BAD_USER(ReturnCode.BAD_REQUEST, "trouble.request.unknownUser"),

    /**
     * Bad backend: backend failed to perform its operation.
     */
    BAD_BACKEND(ReturnCode.CORE_SERVICE_ERROR, "trouble.backend"),

    /**
     * Bad backend: backend failed to perform its operation.
     */
    BAD_BACKEND_QUOTA_LIMIT(ReturnCode.CORE_SERVICE_ERROR, "trouble.backend.quota.limit"),

    /**
     * Backend could not be accessed because its backend monitor blocked the request.
     */
    BLOCKED_BY_BACKEND_MONITOR(ReturnCode.CORE_SERVICE_ERROR, "trouble.backend.BlockedByBackendMonitor"),

    /**
     * Unknown host when connecting to backend.
     * <p>
     * SPICA could not connect to the backend, since the hostname is unknown.
     */
    BACKEND_UNKNOWN_HOST(ReturnCode.CORE_SERVICE_ERROR, "trouble.backend.unknownHost"),

    /**
     * Connection timeout when connecting to backend.
     * <p>
     * SPICA could not connect to the backend, possibly due to networking problems, e.g., firewall issues or
     * incorrect adresses.
     */
    BACKEND_CONNECTION_TIMEOUT(ReturnCode.CORE_SERVICE_TIMEOUT, "trouble.backend.timeout.connection"),

    /**
     * Bad backend: backend failed to perform its operation.
     * <p>
     * SPICA could connect to the backend, but the backend did not respond within the timeout.
     */
    BACKEND_RESPONSE_TIMEOUT(ReturnCode.CORE_SERVICE_TIMEOUT, "trouble.backend.timeout.response"),

    /**
     * Bad request: Service not found
     * SPICA could not find the requested handler
     */
    SERVICE_NOT_FOUND(ReturnCode.NOT_FOUND, "trouble.service.notfound"),

    /**
     * Method Not Allowed
     * SPICA does not support the HTTP method
     */
    METHOD_NOT_ALLOWED(ReturnCode.METHOD_NOT_ALLOWED, "trouble.method.notallowed"),

    /**
     * Unsupported Media Type
     * SPICA does not support the media type
     */
    UNSUPPORTED_MEDIA_TYPE(ReturnCode.UNSUPPORTED_MEDIA_TYPE, "trouble.mediatype.unsupported"),

    /**
     * Resource does not have a current representation that would be acceptable to the user agent
     */
    NOT_ACCEPTABLE(ReturnCode.NOT_ACCEPTABLE, "trouble.mediatype.notacceptable");

    private final ReturnCode returnCode;
    private final String errorId;

    private DefaultErrorInfo(ReturnCode returnCode, String errorId) {
        this.returnCode = returnCode;
        this.errorId = errorId;
    }

    /**
     * Creates a {@link DefaultErrorInfo} enum from an errorId.
     * Throws an {@link IllegalArgumentException} if the creation of a {@link DefaultErrorInfo} failed.
     *
     * @param errorId The error id.
     * @return a {@link DefaultErrorInfo} instance.
     */
    public static DefaultErrorInfo fromErrorId(String errorId) {
        for (DefaultErrorInfo errorInfo : DefaultErrorInfo.values()) {
            if (errorId.equals(errorInfo.getErrorId())) {
                return errorInfo;
            }
        }
        return DEFAULT_FRAMEWORK_EXCEPTION;
    }

    public static DefaultErrorInfo fromReturnCode(ReturnCode returnCode) {
        for (DefaultErrorInfo errorInfo : DefaultErrorInfo.values()) {
            if (errorInfo.getReturnCode().equals(returnCode)) {
                return errorInfo;
            }
        }
        return DEFAULT_FRAMEWORK_EXCEPTION;
    }

    @Override
    public ReturnCode getReturnCode() {
        return this.returnCode;
    }

    @Override
    public String getErrorId() {
        return this.errorId;
    }
}
