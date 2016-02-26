package org.experiment.lang.generic;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The description of an error.
 */
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@ApiModel(description = "The description of an error.")
public final class ErrorDescription {

    /**
     * The status code of an error.
     * See <a href="index.html#error_handling">here</a> for possible values.
     */
    @XmlAttribute(required = true)
    @ApiModelProperty(value = "The status code of an error.")
    private final Integer statusCode;

    /**
     * An identifier for the error. This identifier gives more details about the cause of the error beyond the
     * status code. It is a specific string that clients can use to distinguish different errors.
     */
    @XmlAttribute(required = true)
    @ApiModelProperty(value = "An identifier for the error. This identifier gives more details about the cause of the error beyond the" +
            " status code. It is a specific string that clients can use to distinguish different errors.")
    private final String errorId;

    /**
     * A more detailed description of the error intended for human consumption.
     */
    @XmlElement(required = true)
    @ApiModelProperty(value = "A more detailed description of the error intended for human consumption.")
    private final String message;

    /**
     * A stack trace for the error intended for debugging purposes for SPICA developer. This attribute can be ignored
     * by the SPICA clients. In addition, it is filled only in test environments (TOON, VTU).
     */
    @XmlElement(nillable = true, required = false)
    @ApiModelProperty(value = "A stack trace for the error intended for debugging purposes for SPICA developer. This attribute can be ignored" +
            " by the SPICA clients. In addition, it is filled only in test environments.")
    private final String stackTrace;

    /**
     * Constructs a new {@code ErrorDescription}.
     */
    public ErrorDescription() {
        this.statusCode = null;
        this.errorId = null;
        this.message = null;
        this.stackTrace = null;
    }

    /**
     * Constructs a new {@code ErrorDescription}.
     *
     * @param statusCode The status code of the error.
     * @param errorId    The identifier of the error.
     * @param message    A description of the error.
     * @param stackTrace A stack trace for the error.
     */
    public ErrorDescription(int statusCode, String errorId, String message, String stackTrace) {
        this.statusCode = statusCode;
        this.errorId = errorId;
        this.message = message;
        this.stackTrace = stackTrace;
    }

    /**
     * Returns the status code of this error.
     *
     * @return The status code of this error.
     */
    public Integer getStatusCode() {
        return this.statusCode;
    }

    /**
     * Returns the identifier of this error.
     *
     * @return The identifier of this error.
     */
    public String getErrorId() {
        return this.errorId;
    }

    /**
     * Returns the description of this error.
     *
     * @return The description of this error.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Returns the stack trace for this error.
     *
     * @return The stack trace for this error.
     */
    public String getStackTrace() {
        return this.stackTrace;
    }
}
