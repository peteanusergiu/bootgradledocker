package org.experiment.lang.iot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import org.experiment.util.builder.BuilderHelper;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by petea on 3/1/2016.
 */
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class URLS {

    @XmlElement(name = "url")
    @ApiModelProperty(value = "Eddystone's list of URLs. There should be at least one!")
    @NotNull
    private final List<URL> urlList;

    public URLS(List<URL> urls) {
        this.urlList = (CollectionUtils.isEmpty(urls)) ? null : BuilderHelper.copyList(urls);
    }
    public URLS() {
        this.urlList = null;
    }

    public List<URL> getUrlList() {
        return urlList;
    }
}

