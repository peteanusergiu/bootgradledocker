package org.experiment.lang.generic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A response for delete operations.
 *
 * Created by iodavid on 11/25/2015.
 */
@XmlRootElement
@ApiModel(description = "A response for delete operations.")
public class DeleteResponse extends BaseResponse {

    /**
     * The id of the deleted entry.
     */
    @XmlElement
    @ApiModelProperty(value = "The id of the deleted entry.")
    private String id;

    /**
     * Constructs a new {@code DeleteResponse}
     */
    public DeleteResponse() {
        this.id = null;
    }

    /**
     * Constructs a new {@code DeleteResponse}
     *
     * @param id The id of the deleted entry.
     */
    public DeleteResponse(String id) {
        this.id = id;
    }

    /**
     * Returns the id of the deleted entry.
     *
     * @return The id of the deleted entry.
     */
    public String getId() {
        return id;
    }
}
