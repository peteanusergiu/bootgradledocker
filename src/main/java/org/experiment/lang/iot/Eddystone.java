package org.experiment.lang.iot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Eddystone {

    @XmlElement
    @ApiModelProperty(value = "Eddystone's list of UIDs. It can take more values only if someone reconfigure an existing Beacon " +
            "without resetting the initial one!")
    @NotNull
    private final UIDS uids;
    @XmlElement
    @ApiModelProperty(value = "Eddystone's list of TLMs. There should be at least one!")
    @NotNull
    private final TLMS tlms;
    @XmlElement
    @ApiModelProperty(value = "Eddystone's list of URLs. It can take more values only if someone reconfigure an existing Beacon " +
            "without resetting the initial one!")
    @NotNull
    private final URLS urls;

    public Eddystone(UIDS uids, TLMS tlms, URLS urls) {
        this.tlms = tlms;
        this.uids = uids;
        this.urls = urls;
    }

    public Eddystone() {
        this.uids = null;
        this.tlms = null;
        this.urls = null;
    }

    public URLS getUrls() {
        return urls;
    }


    public UIDS getUids() {
        return uids;
    }


    public TLMS getTlms() {
        return tlms;
    }

}
