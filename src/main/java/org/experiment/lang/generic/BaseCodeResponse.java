package org.experiment.lang.generic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A response for create operations.
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@ApiModel(description = "A response for alarm create operations.")
public class BaseCodeResponse extends BaseResponse {

    /**
     * The maximum summary length.
     */
    public static final int SUMMARY_LENGTH_MAX = 40;

    public BaseCodeResponse() {

    }

    public BaseCodeResponse(String returnCode, String summary, String description) {
        this.code = returnCode;
        this.summary = summary;
        this.description = description;
    }

    /**
     * The code response
     */
    @XmlElement
    @ApiModelProperty(value = "The returned code")
    private String code;

    /**
     * The short summary or title of the event.
     */
    @XmlElement
    @Size(max = SUMMARY_LENGTH_MAX)
    @ApiModelProperty(value = "The short summary or title of the event.")
    private String summary;

    /**
     * The description of the event.
     */
    @XmlElement
    @Size(max = 65535)
    @ApiModelProperty(value = "The description of the event.")
    private String description;

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

}