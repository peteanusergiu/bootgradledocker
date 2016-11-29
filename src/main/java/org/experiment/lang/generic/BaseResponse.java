package org.experiment.lang.generic;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A response containing only an error description.
 * Most responses derive from this class.
 */
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@ApiModel(description = "A base response containing only an error description. Most responses derive from this class.")
public class BaseResponse implements IBaseResponse {

    protected ErrorDescription error;

    /**
     * Constructs a new {@code BaseResponse}.
     */
    public BaseResponse() {
        this.error = null;
    }

    /**
     * An error description if an error occurred.
     *
     * @return The error description.
     */
    @Override
    @XmlElement(required = false)
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @ApiModelProperty(value = "An error description if an error occurred.")
    public ErrorDescription getError() {
        return error;
    }
    /**
     * Sets the error description.
     *
     * @param error The error description.
     */
    public void setError(ErrorDescription error) {
        this.error = error;
    }
}
