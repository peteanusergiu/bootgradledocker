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
public class TLMS {

    @XmlElement(name = "tlm")
    @ApiModelProperty(value = "Eddystone's list of TLMs. There should be at least one!")
    @NotNull
    private final List<TLM> tlmList;

    public TLMS(List<TLM> tlms) {
        this.tlmList = (CollectionUtils.isEmpty(tlms)) ? null : BuilderHelper.copyList(tlms);
    }
    public TLMS() {
        this.tlmList = null;
    }

    public List<TLM> getTlmList() {
        return tlmList;
    }
}
