package org.experiment.db.entities.iot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Eddystone's UID frame")
@Entity
@Table(name = "uid")
public class UIDEntity {

    @ApiModelProperty(value = "The entity's unique id")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(value = "The beacon's eddystone namespace id")
    protected String id_namespace;

    @ApiModelProperty(value = "The beacon's eddystone namespace instance")
    protected String id_instance;

    protected String uids;
    protected String power;
    protected String mfg_id;
    protected String service_uuid;
    protected String rssi;


    public String getId_namespace() {
        return id_namespace;
    }

    public void setId_namespace(String id_namespace) {
        this.id_namespace = id_namespace;
    }

    public String getId_instance() {
        return id_instance;
    }

    public void setId_instance(String id_instance) {
        this.id_instance = id_instance;
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
