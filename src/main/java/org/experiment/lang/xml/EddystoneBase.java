package org.experiment.lang.xml;

public class EddystoneBase {
    protected String uids;
    protected String power;
    protected String mfg_id;
    protected String service_uuid;
    protected String rssi;


    public void setUids(String uids) {
        this.uids = uids;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setMfg_id(String mfg_id) {
        this.mfg_id = mfg_id;
    }

    public void setService_uuid(String service_uuid) {
        this.service_uuid = service_uuid;
    }

    public void setRssi(String rssi) {
        this.rssi = rssi;
    }

    public String getUids() {
        return uids;
    }

    public String getPower() {
        return power;
    }

    public String getMfg_id() {
        return mfg_id;
    }

    public String getService_uuid() {
        return service_uuid;
    }

    public String getRssi() {
        return rssi;
    }
}
