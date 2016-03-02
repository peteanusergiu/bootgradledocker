package org.experiment.db.entities.iot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Eddystone's UID frame")
@Entity
@Table(name = "uid")
public class UIDEntity {


    @ApiModelProperty(value = "The beacon's eddystone namespace id")
    private String id_namespace;

    @Id
    @ApiModelProperty(value = "The beacon's eddystone namespace instance")
    private String id_instance;

    private String minor;
    private String major;

    private String uuid;
    private String power;
    private String mfg_id;
    private String service_uuid;
    private String rssi;

    public UIDEntity() {
    }

    public UIDEntity(String id_namespace, String id_instance, String minor, String major, String uuid, String power, String mfg_id, String service_uuid, String rssi) {

        this.id_namespace = id_namespace;
        this.id_instance = id_instance;
        this.minor = minor;
        this.major = major;
        this.uuid = uuid;
        this.power = power;
        this.mfg_id = mfg_id;
        this.service_uuid = service_uuid;
        this.rssi = rssi;
    }


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

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object object) {
        return (
                (object != null)
                        &&
                        (object instanceof UIDEntity)
                        &&
                        (this.id_instance.equals(((UIDEntity) object).getId_instance()))
        );
    }

    @Override
    public int hashCode() {
        return id_instance.hashCode();
    }
}
