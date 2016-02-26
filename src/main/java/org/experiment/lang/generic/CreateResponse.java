package org.experiment.lang.generic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A response for create operations.
 *
 */
@XmlRootElement
@ApiModel(description = "A response for IOT create  operations.")
public class CreateResponse extends BaseResponse {

    /**
     * The maximum summary length.
     */
    public static final int SUMMARY_LENGTH_MAX = 40;

    public CreateResponse(String mac, String summary, String description) {
        this.mac = mac;
        this.summary = summary;
        this.description = description;
    }

    /**
     * The identifier of the IOT.
     */
    @XmlAttribute
    @ApiModelProperty(value = "The identifier of the event.")
    private final String mac;

    /**
     * The short summary or title of the event.
     */
    @XmlElement
    @Size(max = SUMMARY_LENGTH_MAX)
    @ApiModelProperty(value = "The short summary or title of the event.")
    private final String summary;

    /**
     * The description of the event.
     */
    @XmlElement
    @Size(max = 65535)
    @ApiModelProperty(value = "The description of the event.")
    private final String description;

    public String getMac() {
        return mac;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }
}