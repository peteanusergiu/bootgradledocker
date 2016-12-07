package org.experiment.lang.amqp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import org.experiment.lang.generic.BaseCodeResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "receiverResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiverResponse extends BaseCodeResponse {

    @XmlElement(name = "message")
    @ApiModelProperty(value = "MQTT message ")
    private Location message;

    public ReceiverResponse(){
        super("200", "All good", "All good");
    }

    public ReceiverResponse(Location message){
        super("200", "All good", "All good");
        this.message = message;
    }

    public ReceiverResponse(String returnCode, String summary, String description) {
        super(returnCode, summary, description);
    }


    public Location getMessage() {
        return message;
    }

    public void setMessage(Location message) {
        this.message = message;
    }
}
