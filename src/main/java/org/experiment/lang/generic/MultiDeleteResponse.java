package org.experiment.lang.generic;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * A response for multi delete operations with different results
 * Created by iodavid on 11/25/2015.
 */
@XmlRootElement
@ApiModel(description = "A response for multi delete operations with different results.")
public class MultiDeleteResponse extends BaseResponse {

    /**
     * The list of {@code DeleteResponse}.
     */
    @XmlElement
    @ApiModelProperty(value = "This is a list of delete responses.")
    private List<DeleteResponse> responses;


    /**
     * Creates a new {@code MultiDeleteResponse}.
     */
    public MultiDeleteResponse() {
        this.responses = null;
    }

    /**
     * Creates a new {@code MultiDeleteResponse}.
     *
     * @param responses The list of delete responses.
     */
    public MultiDeleteResponse(List<DeleteResponse> responses) {
        this.responses = responses;
    }

    /**
     * Returns the list of delete responses.
     *
     * @return The list of delete responses.
     */
    public List<DeleteResponse> getResponses() {
        return responses;
    }
}
