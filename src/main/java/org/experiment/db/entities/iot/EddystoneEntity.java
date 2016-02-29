package org.experiment.db.entities.iot;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "beacon")
public class EddystoneEntity {

    @ApiModelProperty(value = "Eddystone's unique id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @ApiModelProperty(value = "Eddystone's relation with IOT - Many2One; as an IOT(MAC) can have more beacons over time (same hardware but different info)")
    @OneToOne(mappedBy = "beacon", optional = true)
    protected IOTEntity iot;

    @ApiModelProperty(value = "Eddystone's list of UIDs. It can take more values only if someone reconfigure an existing Beacon " +
            "without resetting the initial one!")
    @OneToMany
    @JoinColumn(name = "uid_id")
    protected List<UIDEntity> uids;

    @ApiModelProperty(value = "Eddystone's list of TLMs. There should be at least one!")
    @OneToMany
    @JoinColumn(name = "tlm_id")
    protected List<TLMEntity> tlms;

    @ApiModelProperty(value = "Eddystone's list of URLs. It can take more values only if someone reconfigure an existing Beacon " +
            "without resetting the initial one!")
    @OneToMany
    @JoinColumn(name = "url_id")
    protected List<URLEntity> urls;

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

    public List<UIDEntity> getUids() {
        return uids;
    }

    public void setUids(List<UIDEntity> uids) {
        this.uids = uids;
    }

    public List<TLMEntity> getTlms() {
        return tlms;
    }

    public void setTlms(List<TLMEntity> tlms) {
        this.tlms = tlms;
    }

    public List<URLEntity> getUrls() {
        return urls;
    }

    public void setUrls(List<URLEntity> urls) {
        this.urls = urls;
    }
}
