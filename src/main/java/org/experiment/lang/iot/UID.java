package org.experiment.lang.iot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@ApiModel(description = "Eddystone's UID frame")
public class UID {

    public UID(String id_namespace, String id_instance, String minor, String major, String uids, String power, String mfg_id, String service_uuid, String rssi) {
        this.id_namespace = id_namespace;
        this.id_instance = id_instance;
        this.minor = minor;
        this.major = major;
        this.uuid = uids;
        this.power = power;
        this.mfg_id = mfg_id;
        this.service_uuid = service_uuid;
        this.rssi = rssi;
    }

    public UID() {
        this.id_namespace = null;
        this.id_instance = null;
        this.minor = null;
        this.major = null;
        this.uuid = null;
        this.power = null;
        this.mfg_id = null;
        this.service_uuid = null;
        this.rssi = null;
    }

    @XmlElement
    @ApiModelProperty(value = "The beacon's eddystone namespace id")
    @NotNull
    private final String id_namespace;

    @XmlElement
    @ApiModelProperty(value = "The beacon's eddystone namespace instance")
    @NotNull
    private final String id_instance;

    @XmlElement
    @ApiModelProperty(value = "The beacon's eddystone minor")
    private final String minor;

    @XmlElement
    @ApiModelProperty(value = "The beacon's eddystone major")
    private final String major;

    @ApiModelProperty(value = "")
    @XmlElement
    @NotNull
    private final String uuid;
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

    public String getId_namespace() {
        return id_namespace;
    }

    public String getId_instance() {
        return id_instance;
    }

    public String getUuid() {
        return uuid;
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

    public String getMinor() {
        return minor;
    }

    public String getMajor() {
        return major;
    }
}