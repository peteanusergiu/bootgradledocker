package org.experiment.lang.iot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "iot")
public class IOT {

    public IOT() {
        this.beacon = null;
        this.mac = null;
        this.type = null;
    }

    public IOT(Eddystone beacon, String mac, String type) {
        this.beacon = beacon;
        this.mac = mac;
        this.type = type;
    }

    @XmlElement(name = "eddystone")
    @ApiModelProperty(value = "The beacon's object <default, for now, to Eddystone.>")
    @NotNull
    private final Eddystone beacon;

    @XmlElement
    @ApiModelProperty(value = "The unique MAC for one IOT")
    @NotNull
    private final String mac;

    @XmlElement
    @ApiModelProperty(value = "The beacon's type <default, for now, to eddystone.>")
    @NotNull
    private final String type;

    public Eddystone getBeacon() {
        return beacon;
    }

    public String getMac() {
        return mac;
    }

    public String getType() {
        return type;
    }
}
