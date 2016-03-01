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
public class UIDS {

    @XmlElement(name = "uid")
    @ApiModelProperty(value = "Eddystone's list of TLMs. There should be at least one!")
    @NotNull
    private final List<UID> uidList;

    public UIDS(List<UID> uids) {
        this.uidList = (CollectionUtils.isEmpty(uids)) ? null : BuilderHelper.copyList(uids);
    }
    public UIDS() {
        this.uidList = null;
    }

    public List<UID> getUidList() {
        return uidList;
    }
}
