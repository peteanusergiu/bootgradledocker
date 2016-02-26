package org.experiment.util.errormodel;

import org.experiment.util.ReturnCode;

/**
 * This exception is used across REST project to indicate expected problems such as
 * bad authorization, unavailable backends, etc.
 *
 */
public abstract class CustomTrouble extends Exception implements IErrorInfo {

    private final IErrorInfo errorInfo;

    /**
     * The constructor with an {@link IErrorInfo}.
     *
     * @param errorInfo the {@link IErrorInfo}.
     */
    public CustomTrouble(IErrorInfo errorInfo) {
        super(errorInfo.getErrorId());
        this.errorInfo = errorInfo;
    }

    /**
     * The constructor with an {@link IErrorInfo} and a message.
     *
     * @param errorInfo the {@link IErrorInfo}.
     * @param message   The message.
     */
    public CustomTrouble(IErrorInfo errorInfo, String message) {
        super(message);
        this.errorInfo = errorInfo;
    }

    /**
     * The constructor with an {@link IErrorInfo} and the {@link Throwable} cause.
     *
     * @param errorInfo the {@link IErrorInfo}.
     * @param cause     The cause.
     */
    public CustomTrouble(IErrorInfo errorInfo, Throwable cause) {
        super((cause == null || cause.getMessage() == null) ? errorInfo.getErrorId() : cause.getMessage(), cause);
        this.errorInfo = errorInfo;
    }

    /**
     * The constructor with an {@link IErrorInfo}, a message and the {@link Throwable} cause.
     *
     * @param errorInfo the {@link IErrorInfo}.
     * @param message   The message.
     * @param cause     The cause.
     */
    public CustomTrouble(IErrorInfo errorInfo, String message, Throwable cause) {
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

    public final IErrorInfo getErrorInfo() {
        return this.errorInfo;
    }
}

