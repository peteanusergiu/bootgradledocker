package org.experiment.lang.amqp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "location")
@XmlAccessorType(XmlAccessType.FIELD)
public class Location {
    @XmlElement(name = "latitude")
    @ApiModelProperty(value = "latitude")
    private Double latitude;

    @XmlElement(name = "longitude")
    @ApiModelProperty(value = "longitude")
    private Double longitude;

    public Location() {
        this(0d, 0d);
    }
    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double Longitude) {
        this.longitude = Longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString(){
        return String.format("{\"latitude\": \"%s\", \"longitude\": \"%s\"}", getLatitude(), getLongitude());
    }
}
