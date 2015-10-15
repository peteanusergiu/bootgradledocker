package org.experiment.lang;

public class RestResponse {
	
	private String message;
	private String name;
	
	public RestResponse(String message, String name) {
		this.message = String.format(message, name);
		this.setName(name);
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
