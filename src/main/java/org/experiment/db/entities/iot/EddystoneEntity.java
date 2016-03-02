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
    @Column(name = "id")
    private String id;

    @ApiModelProperty(value = "Eddystone's relation with IOT - Many2One; as an IOT(MAC) can have more beacons over time (same hardware but different info)")
    @OneToOne(mappedBy = "beacon")
    @MapsId
    @JoinColumn(name = "id")
    private IOTEntity iot;

    @ApiModelProperty(value = "Eddystone's list of UIDs. It can take more values only if someone reconfigure an existing Beacon " +
            "without resetting the initial one!")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "beacon_id", nullable = true)
    private Set<UIDEntity> uids = new HashSet<>();

    @ApiModelProperty(value = "Eddystone's list of TLMs. There should be at least one!")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "beacon_id", nullable = true)
    private Set<TLMEntity> tlms = new HashSet<>();

    @ApiModelProperty(value = "Eddystone's list of URLs. It can take more values only if someone reconfigure an existing Beacon " +
            "without resetting the initial one!")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "beacon_id", nullable = true)
    private Set<URLEntity> urls = new HashSet<>();

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode(){
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return (
                (object != null)
                &&
                (object instanceof EddystoneEntity)
                &&
                (this.id.equals(((EddystoneEntity) object).getId()))
        );
    }

}
