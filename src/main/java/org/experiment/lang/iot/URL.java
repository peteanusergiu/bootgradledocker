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
    @ApiModelProperty(value = "The beacon's url")
    @NotNull
    private final String url;
    @ApiModelProperty(value = "")
    @XmlElement
    @NotNull
    private final String uids;
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

    public URL(String url, String uids, String power, String mfg_id, String service_uuid, String rssi) {
        this.url = url;
        this.uids = uids;
        this.power = power;
        this.mfg_id = mfg_id;
        this.service_uuid = service_uuid;
        this.rssi = rssi;
    }

    public URL() {
        this.url = null;
        this.uids = null;
        this.power = null;
        this.mfg_id = null;
        this.service_uuid = null;
        this.rssi = null;
    }

    public String getUrl() {
        return url;
    }

    public String getUids() {
        return uids;
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
