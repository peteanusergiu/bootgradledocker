package org.experiment.lang.iot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@ApiModel(description = "Eddystone's TLM frame - beacons's internal information [sensors, battery,...] ")
public class TLM {
    @XmlElement
    @ApiModelProperty(value = "The beacon's eddystone voltage")
    @NotNull
    private String voltage;

    @XmlElement
    @ApiModelProperty(value = "The beacon's eddystone temperature")
    @NotNull
    private String temperature;

    @XmlElement
    @ApiModelProperty(value = "The beacon's eddystone pdus")
    @NotNull
    private String pdus;


    public String getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) {
        this.seconds = seconds;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPdus() {
        return pdus;
    }

    public void setPdus(String pdus) {
        this.pdus = pdus;
    }

    protected String seconds;
}
