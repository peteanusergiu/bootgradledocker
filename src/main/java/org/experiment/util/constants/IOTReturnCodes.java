package org.experiment.util.constants;

/**
 * Created by petea on 5/31/2016.
 */
public enum IOTReturnCodes {
    OK("IOT-200"), ERROR("IOT-500");

    private String value;

    IOTReturnCodes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
