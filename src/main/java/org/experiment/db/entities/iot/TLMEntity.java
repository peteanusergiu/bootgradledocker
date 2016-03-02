package org.experiment.db.entities.iot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Eddystone's TLM frame - beacons's internal information [sensors, battery,...] ")
@Entity
@Table(name = "tlm")
public class TLMEntity {

    @Id
    @ApiModelProperty(value = "The beacon's eddystone voltage")
    private String seconds;

    @ApiModelProperty(value = "The beacon's eddystone voltage")
    private String voltage;

    @ApiModelProperty(value = "The beacon's eddystone temp")
    private String temp;

    @ApiModelProperty(value = "The beacon's eddystone pdus")
    private String pdus;

    public TLMEntity() {
    }

    public TLMEntity(String seconds, String voltage, String temperature, String pdus) {
        this.seconds = seconds;
        this.voltage = voltage;
        this.temp = temperature;
        this.pdus = pdus;
    }

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

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPdus() {
        return pdus;
    }

    public void setPdus(String pdus) {
        this.pdus = pdus;
    }

    @Override
    public boolean equals(Object object) {
        return (
                (object != null)
                        &&
                        (object instanceof TLMEntity)
                        &&
                        (this.seconds.equals(((TLMEntity) object).getSeconds()))
        );
    }

    @Override
    public int hashCode() {
        return seconds.hashCode();
    }
}
