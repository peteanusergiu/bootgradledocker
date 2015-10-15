package org.experiment.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "send")
public class RestProperties {
	private String visitor;
	private String message;
	
	public String getVisitor() {
		return visitor;
	}
	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
