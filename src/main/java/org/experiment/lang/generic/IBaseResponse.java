package org.experiment.lang.generic;

/**
 * The base class for most responses.
 */
public interface IBaseResponse {

    /**
     * Returns an error description.
     *
     * @return An error description or {@code null} if no error description is available.
     */
    ErrorDescription getError();
}

