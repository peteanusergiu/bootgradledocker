package org.experiment.db.entities.iot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Eddystone's URL frame")
@Entity
@Table(name = "url")
public class URLEntity {

    @ApiModelProperty(value = "The entity's unique id")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(value = "The beacon's url")
    protected String url;

    protected String uids;
    protected String power;
    protected String mfg_id;
    protected String service_uuid;

    public URLEntity() {
    }

    public URLEntity(String url, String uids, String power, String mfg_id, String service_uuid, String rssi) {

        this.url = url;
        this.uids = uids;
        this.power = power;
        this.mfg_id = mfg_id;
        this.service_uuid = service_uuid;
        this.rssi = rssi;
    }

    protected String rssi;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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
