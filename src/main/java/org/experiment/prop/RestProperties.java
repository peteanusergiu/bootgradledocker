package org.experiment.prop;

import org.experiment.util.Properties;
import org.experiment.extensions.annotation.EnumOwner;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "send")
public class RestProperties {
	private String visitor;
	private String message;

    /*validating the yml property to an enum of type enumType*/
    @EnumOwner(enumType = Properties.class)
	private String enumValue;
	
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

    public Properties getEnumValue() {
        return Properties.valueOf(enumValue);
    }

    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue;
    }
}
