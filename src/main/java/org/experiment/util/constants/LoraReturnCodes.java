package org.experiment.util.constants;

/**
 * Created by petea on 5/31/2016.
 */
public enum LoraReturnCodes {
    OK("0"), ERROR("1");

    private String value;

    LoraReturnCodes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
