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
public class LocationString {
    @XmlElement(name = "latitude")
    @ApiModelProperty(value = "latitude")
    private String latitude;

    @XmlElement(name = "longitude")
    @ApiModelProperty(value = "longitude")
    private String longitude;

    public LocationString() {
        this("0", "0");
    }
    public LocationString(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString(){
        return String.format("{\"latitude\": \"%s\", \"longitude\": \"%s\"}", getLatitude(), getLongitude());
    }
}
