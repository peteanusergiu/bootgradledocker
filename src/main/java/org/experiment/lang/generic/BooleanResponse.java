package org.experiment.lang.generic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * A response with two possible outcomes.
 */
@XmlRootElement
@ApiModel(description = "A response with two possible outcomes.")
public final class BooleanResponse extends BaseResponse implements Serializable {

    /**
     * The value of a boolean response. Either &quot;true&quot; or &quot;false&quot;.
     */
    @XmlElement
    @ApiModelProperty(value = "The value of a boolean response. Either true or false.")
    private final Boolean value;

    /**
     * Constructs a new {@code BooleanResponse}.
     */
    public BooleanResponse() {
        this.value = null;
    }

    /**
     * Constructs a new {@code BooleanResponse}.
     *
     * @param value The value of the response.
     */
    public BooleanResponse(boolean value) {
        this.value = value;
    }

    /**
     * Returns the boolean value of this response.
     *
     * @return The boolean value of this response.
     */
    public Boolean isValue() {
        return this.value;
    }
}

