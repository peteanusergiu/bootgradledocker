package org.experiment.lang.iot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@ApiModel(description = "All beacons common information - BLE's default package")
public class EddystoneBase {
    @ApiModelProperty(value = "")
    @XmlElement
    @NotNull
    protected String uids;
    @ApiModelProperty(value = "")
    @XmlElement
    @NotNull
    protected String power;
    @ApiModelProperty(value = "")
    @XmlElement
    protected String mfg_id;
    @XmlElement
    @NotNull
    protected String service_uuid;
    @ApiModelProperty(value = "")
    @XmlElement
    protected String rssi;


    public void setUids(String uids) {
        this.uids = uids;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setMfg_id(String mfg_id) {
        this.mfg_id = mfg_id;
    }

    public void setService_uuid(String service_uuid) {
        this.service_uuid = service_uuid;
    }

    public void setRssi(String rssi) {
        this.rssi = rssi;
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
