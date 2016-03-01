package org.experiment.db.entities.iot;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "beacon")
public class EddystoneEntity {

    @ApiModelProperty(value = "Eddystone's unique id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "Eddystone's relation with IOT - Many2One; as an IOT(MAC) can have more beacons over time (same hardware but different info)")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iot_id", unique = true, nullable = true)
    private IOTEntity iot;

    @ApiModelProperty(value = "Eddystone's list of UIDs. It can take more values only if someone reconfigure an existing Beacon " +
            "without resetting the initial one!")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "beacon_id", nullable = true)
    private Set<UIDEntity> uids = new HashSet<>();

    @ApiModelProperty(value = "Eddystone's list of TLMs. There should be at least one!")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "beacon_id" , nullable = true)
    private Set<TLMEntity> tlms = new HashSet<>();

    @ApiModelProperty(value = "Eddystone's list of URLs. It can take more values only if someone reconfigure an existing Beacon " +
            "without resetting the initial one!")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "beacon_id", nullable = true)
    private Set<URLEntity> urls = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IOTEntity getIot() {
        return iot;
    }

    public void setIot(IOTEntity iot) {
        this.iot = iot;
    }

    public Set<UIDEntity> getUids() {
        return uids;
    }

    public void setUids(Set<UIDEntity> uids) {
        this.uids = uids;
    }

    public Set<TLMEntity> getTlms() {
        return tlms;
    }

    public void setTlms(Set<TLMEntity> tlms) {
        this.tlms = tlms;
    }

    public Set<URLEntity> getUrls() {
        return urls;
    }

    public void setUrls(Set<URLEntity> urls) {
        this.urls = urls;
    }
}
