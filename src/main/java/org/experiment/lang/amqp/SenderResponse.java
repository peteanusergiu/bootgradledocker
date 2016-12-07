package org.experiment.lang.amqp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.experiment.lang.generic.BaseCodeResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "senderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SenderResponse extends BaseCodeResponse {

    public SenderResponse(){}


    public SenderResponse(String code, String summary, String details) {
        super(code, summary, details);

    }
}
