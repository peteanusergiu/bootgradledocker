// Project:   Deutsche Telekom - SPICA
// Author:    Josef Adersberger <josef.adersberger@qaware.de>
// Copyright: QAware GmbH

package org.experiment.util.errormodel;

/**
 * Exception type for unexpected error situations inside the SPICA framework
 */
public class FrameworkException extends CustomException {

    /**
     * The constructor with a message.
     *
     * @param message The message.
     */
    public FrameworkException(String message) {
        super(DefaultErrorInfo.DEFAULT_FRAMEWORK_EXCEPTION, message);
    }

    /**
     * The constructor with cause parameter ({@link Throwable}).
     *
     * @param cause the cause
     */
    public FrameworkException(Throwable cause) {
        super(DefaultErrorInfo.DEFAULT_FRAMEWORK_EXCEPTION, cause);
    }

    /**
     * The constructor with a message and the {@link Throwable} cause.
     *
     * @param message The message.
     * @param cause   The cause.
     */
    public FrameworkException(String message, Throwable cause) {
        super(DefaultErrorInfo.DEFAULT_FRAMEWORK_EXCEPTION, message, cause);
    }

    /**
     * The constructor with a message and the {@link CustomTrouble} cause.
     * This constructor maps a checked exception to a runtime exception.
     *
     * @param message The message.
     * @param cause   The cause.
     */
    public FrameworkException(String message, CustomTrouble cause) {
        super(cause.getErrorInfo(), message, cause);
    }


}
