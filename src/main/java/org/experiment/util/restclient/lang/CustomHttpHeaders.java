package org.experiment.util.restclient.lang;

public enum CustomHttpHeaders {


    /**
     * The HTTP header of the unique request ID
     */
    X_REQUEST_ID("X-Request-ID"),

    /**
     * The name of the host which generated a HTTP response
     */
    GENERATED_BY_HEADER("Generated-By");

    private final String header;

    /**
     * @param header The HTTP header representation
     */
    private CustomHttpHeaders(final String header) {
        this.header = header;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return header;
    }
}
