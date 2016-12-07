package org.experiment.lang.amqp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "sender")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sender {

    @XmlElement(name = "exchange")
    @ApiModelProperty(value = "MQTT exchange")
    private String exchange;

    @XmlElement(name = "exchangeType")
    @ApiModelProperty(value = "MQTT exchange type [direct, panout, topic]")
    private String exchangeType;

    @XmlElement(name = "queue")
    @ApiModelProperty(value = "MQTT queue ")
    private String queue;

    @XmlElement(name = "bindingKey")
    @ApiModelProperty(value = "MQTT bindingKey ")
    private String bindingKey;

    @XmlElement(name = "message")
    @ApiModelProperty(value = "MQTT message ")
    private LocationString message;


    public Sender(){}

    public Sender(String exchange, String exchangeType, String queue,String bindingKey, LocationString message) {
        this.exchange = exchange;
        this.exchangeType = exchangeType;
        this.queue = queue;
        this.bindingKey = bindingKey;
        this.message = message;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public LocationString getMessage() {
        return message;
    }

    public void setMessage(LocationString message) {
        this.message = message;
    }

    public String getBindingKey() {
        return bindingKey;
    }

    public void setBindingKey(String bindingKey) {
        this.bindingKey = bindingKey;
    }
}
