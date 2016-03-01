package org.experiment.lang.iot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import org.experiment.util.builder.BuilderHelper;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Eddystone {

    @XmlElement
    @ApiModelProperty(value = "Eddystone's list of UIDs. It can take more values only if someone reconfigure an existing Beacon " +
            "without resetting the initial one!")
    @NotNull
    private final List<UID> uids;
    @XmlElement
    @ApiModelProperty(value = "Eddystone's list of TLMs. There should be at least one!")
    @NotNull
    private final List<TLM> tlms;
    @XmlElement
    @ApiModelProperty(value = "Eddystone's list of URLs. It can take more values only if someone reconfigure an existing Beacon " +
            "without resetting the initial one!")
    @NotNull
    private final List<URL> urls;

    public Eddystone(List<UID> uids, List<TLM> tlms, List<URL> urls) {
        this.uids = (CollectionUtils.isEmpty(uids)) ? null : BuilderHelper.copyList(uids);
        this.tlms = (CollectionUtils.isEmpty(tlms)) ? null : BuilderHelper.copyList(tlms);
        this.urls = (CollectionUtils.isEmpty(urls)) ? null : BuilderHelper.copyList(urls);
    }

    public Eddystone() {
        this.uids = null;
        this.tlms = null;
        this.urls = null;
    }

    public List<URL> getUrls() {
        return urls;
    }


    public List<UID> getUids() {
        return uids;
    }


    public List<TLM> getTlms() {
        return tlms;
    }

}
