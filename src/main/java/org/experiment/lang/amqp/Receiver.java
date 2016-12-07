package org.experiment.lang.amqp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "receiver")
@XmlAccessorType(XmlAccessType.FIELD)
public class Receiver{

    @XmlElement(name = "queue")
    @ApiModelProperty(value = "MQTT queue to subscribe to ")
    private String queue;

    public Receiver(){}

    public Receiver(String queue) {
        this.queue = queue;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }
}
