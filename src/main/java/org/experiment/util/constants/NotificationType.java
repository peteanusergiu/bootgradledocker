package org.experiment.util.constants;

/**
 * Created by petea on 5/12/2016.
 */
public enum NotificationType {
    EMAIL("EMAIL"), SMS("SMA"), CALL("CALL");

    private String value;

    NotificationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
