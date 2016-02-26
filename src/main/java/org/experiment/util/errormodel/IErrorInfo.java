package org.experiment.util.errormodel;

import org.experiment.util.ReturnCode;

/**
 * Represents the error information to return to a client.
 */
public interface IErrorInfo {
    /**
     * Returns the return code associated with this error.
     *
     * @return The return code.
     */
    ReturnCode getReturnCode();

    /**
     * Returns a unique ID associated with this error.
     *
     * The error ID <em>should</em> use the conventions of Java package names to represent hierarchical
     * dependencies, e.g., {@code trouble.authorization.invalidToken}. Each error ID should have a root
     * "package" of {@code trouble} or {@code exception} to match its severity.
     *
     * @return The unique error ID.
     */
    String getErrorId();
}
