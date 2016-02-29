package org.experiment.db.entities.iot;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


/**
 * The representation of IOT in the backend.
 */
@Entity
@Table(name = "iot")
public class IOTEntity {

    @ApiModelProperty(value = "The beacon's unique id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(value = "The beacon's object <default, for now, to Eddystone.>")
    @OneToOne(optional = true)
    @JoinColumn(name = "beacon_id", unique = true, nullable = true)
    private EddystoneEntity beacon;

    @ApiModelProperty(value = "The unique MAC for one IOT")
    private String mac;

    @ApiModelProperty(value = "The beacon's type <default, for now, to eddystone.>")
    private String type;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

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
}

