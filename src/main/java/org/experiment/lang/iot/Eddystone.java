package org.experiment.lang.iot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Eddystone {

    @XmlElement
    @ApiModelProperty(value = "Eddystone's list of UIDs. It can take more values only if someone reconfigure an existing Beacon " +
            "without resetting the initial one!")
    @NotNull
    protected List<UID> uids;
    @XmlElement
    @ApiModelProperty(value = "Eddystone's list of TLMs. There should be at least one!")
    @NotNull
    protected List<TLM> tlms;
    @XmlElement
    @ApiModelProperty(value = "Eddystone's list of URLs. It can take more values only if someone reconfigure an existing Beacon " +
            "without resetting the initial one!")
    @NotNull
    protected List<URL> urls;


    public List<URL> getUrls() {
        return urls;
    }

    public void setUrls(List<URL> urls) {
        this.urls = urls;
    }

    public List<UID> getUids() {
        return uids;
    }

    public void setUids(List<UID> uids) {
        this.uids = uids;
    }

    public List<TLM> getTlms() {
        return tlms;
    }

    public void setTlms(List<TLM> tlms) {
        this.tlms = tlms;
    }
}
