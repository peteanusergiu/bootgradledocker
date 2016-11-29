package org.experiment.util.constants;

/**
 * Created by petea on 5/28/2016.
 */
public enum BicycleStatus {
    CLEAN("CLEAN"), STOLEN("STOLEN"), SALE("SALE"), TRACKING("TRACKING"), PROTECTED("PROTECTED");

    private String value;

    BicycleStatus(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
