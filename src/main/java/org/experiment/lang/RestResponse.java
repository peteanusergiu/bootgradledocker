package org.experiment.lang;

import org.experiment.db.entities.Customer;

public class RestResponse {
	
	private String message;
	private String name;
	
	public RestResponse(String message, String name) {
		this.message = String.format(message, name);
		this.setName(name);
	}

	public RestResponse(Customer customer) {
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
