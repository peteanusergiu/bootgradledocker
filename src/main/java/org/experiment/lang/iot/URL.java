package org.experiment.lang.iot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@ApiModel(description = "Eddystone's URL frame")
public class URL {
    @XmlElement
    @ApiModelProperty(value = "The beacon's uri")
    @NotNull
    private final String uri;
    @ApiModelProperty(value = "")
    @XmlElement
    @NotNull
    private final String ids;
    @ApiModelProperty(value = "")
    @XmlElement
    @NotNull
    private final String power;
    @ApiModelProperty(value = "")
    @XmlElement
    private final String mfg_id;
    @XmlElement
    private final String service_uuid;
    @ApiModelProperty(value = "")
    @XmlElement
    private final String rssi;

    public URL(String url, String ids, String power, String mfg_id, String service_uuid, String rssi) {
        this.uri = url;
        this.ids = ids;
        this.power = power;
        this.mfg_id = mfg_id;
        this.service_uuid = service_uuid;
        this.rssi = rssi;
    }

    public URL() {
        this.uri = null;
        this.ids = null;
        this.power = null;
        this.mfg_id = null;
        this.service_uuid = null;
        this.rssi = null;
    }

    public String getUri() {
        return uri;
    }

    public String getIds() {
        return ids;
    }

    public String getPower() {
        return power;
    }

    public String getMfg_id() {
        return mfg_id;
    }

    public String getService_uuid() {
        return service_uuid;
    }

    public String getRssi() {
        return rssi;
    }
}
