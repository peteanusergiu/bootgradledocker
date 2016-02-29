package org.experiment.lang.xml;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.experiment.db.entities.test.CustomerEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RestResponse {
	
	private String message;
	private String name;
	
	public RestResponse(String message, String name) {
		this.message = String.format(message, name);
		this.setName(name);
	}

	public RestResponse(CustomerEntity customer) {
		this.message = customer.toString();
		this.name = customer.getFirstName();
	}

	public RestResponse() {
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
