package org.experiment.lang.iot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@ApiModel(description = "Eddystone's TLM frame - beacons's internal information [sensors, battery,...] ")
public class TLM {

    public TLM(String voltage, String temperature, String pdus, String seconds) {
        this.voltage = voltage;
        this.temp = temperature;
        this.pdus = pdus;
        this.seconds = seconds;
    }

    public TLM() {
        this.voltage = null;
        this.temp = null;
        this.pdus = null;
        this.seconds = null;
    }

    @XmlElement
    @ApiModelProperty(value = "The beacon's eddystone voltage")
    @NotNull
    private final String voltage;

    @XmlElement
    @ApiModelProperty(value = "The beacon's eddystone temp")
    @NotNull
    private final String temp;

    @XmlElement
    @ApiModelProperty(value = "The beacon's eddystone pdus")
    private final String pdus;

    @XmlElement
    @NotNull
    private final String seconds;


    public String getSeconds() {
        return seconds;
    }


    public String getVoltage() {
        return voltage;
    }


    public String getTemp() {
        return temp;
    }

    public String getPdus() {
        return pdus;
    }
}
