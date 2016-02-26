package org.experiment.util.errormodel;

import org.experiment.util.ReturnCode;

/**
 * This exception is used across SPICA to indicate unexpected error situations,
 * such as contract violations. SpicaExceptions are generally unrecoverable and
 * indicate a programming error.
 *
 * @see CustomTrouble
 */
public abstract class CustomException extends RuntimeException implements IErrorInfo {
    private final IErrorInfo errorInfo;

    /**
     * The constructor with {@link IErrorInfo} and message parameter.
     *
     * @param errorInfo The error information
     * @param message   The message
     */
    public CustomException(IErrorInfo errorInfo, String message) {
        super(message);
        this.errorInfo = errorInfo;
    }

    /**
     * The constructor with an {@link IErrorInfo} and the {@link Throwable} cause.
     *
     * @param errorInfo the {@link IErrorInfo}.
     * @param cause     The cause.
     */
    public CustomException(IErrorInfo errorInfo, Throwable cause) {
        super(cause);
        this.errorInfo = errorInfo;
    }

    /**
     * The constructor with an {@link IErrorInfo}, a message and the {@link Throwable} cause.
     *
     * @param errorInfo the {@link IErrorInfo}.
     * @param message   The message.
     * @param cause     The cause.
     */
    public CustomException(IErrorInfo errorInfo, String message, Throwable cause) {
        super(message, cause);
        this.errorInfo = errorInfo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final ReturnCode getReturnCode() {
        return this.errorInfo.getReturnCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getErrorId() {
        return this.errorInfo.getErrorId();
    }
}
