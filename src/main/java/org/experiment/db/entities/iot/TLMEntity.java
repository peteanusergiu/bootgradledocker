package org.experiment.db.entities.iot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Eddystone's TLM frame - beacons's internal information [sensors, battery,...] ")
@Entity
@Table(name = "tlm")
public class TLMEntity {

    @ApiModelProperty(value = "The beacon's unique id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(value = "The beacon's eddystone voltage")
    protected String seconds;


    @ApiModelProperty(value = "The beacon's eddystone voltage")
    private String voltage;

    @ApiModelProperty(value = "The beacon's eddystone temperature")
    private String temperature;


    @ApiModelProperty(value = "The beacon's eddystone pdus")
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
}
