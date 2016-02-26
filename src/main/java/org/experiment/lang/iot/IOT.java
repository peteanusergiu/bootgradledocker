package org.experiment.lang.iot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "iot")
public class IOT {

    @XmlElement(name = "eddystone")
    @ApiModelProperty(value = "The beacon's object <default, for now, to Eddystone.>")
    @NotNull
    private Eddystone beacon;

    @XmlElement
    @ApiModelProperty(value = "The unique MAC for one IOT")
    @NotNull
    private String mac;

    @XmlElement
    @ApiModelProperty(value = "The beacon's type <default, for now, to eddystone.>")
    private String type;


    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Eddystone getBeacon() {
        return beacon;
    }

    public void setBeacon(Eddystone beacon) {
        this.beacon = beacon;
    }

}
