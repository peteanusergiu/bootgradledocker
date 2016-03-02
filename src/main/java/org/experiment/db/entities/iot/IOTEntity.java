package org.experiment.db.entities.iot;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


/**
 * The representation of IOT in the backend.
 */
@Entity
@Table(name = "iot")
public class IOTEntity {

    @Id
    @ApiModelProperty(value = "The unique MAC for one IOT. PK key as well")
    private String mac;

    @ApiModelProperty(value = "The beacon's object <default, for now, to Eddystone.>")
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private EddystoneEntity beacon;

    @ApiModelProperty(value = "The beacon's type <default, for now, to eddystone.>")
    private String type;

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EddystoneEntity getBeacon() {
        return beacon;
    }

    public void setBeacon(EddystoneEntity beacon) {
        this.beacon = beacon;
    }

    @Override
    public boolean equals(Object object) {
        return (
                (object != null)
                        &&
                        (object instanceof IOTEntity)
                        &&
                        (this.mac.equals(((IOTEntity) object).getMac()))
        );
    }

    @Override
    public int hashCode() {
        return mac.hashCode();
    }
}

