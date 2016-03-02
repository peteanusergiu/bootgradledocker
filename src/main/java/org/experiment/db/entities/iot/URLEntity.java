package org.experiment.db.entities.iot;

import javax.persistence.*;

@Entity
@Table(name = "url")
public class URLEntity {

    @Id
    private String ids;

    private String uri;
    private String power;
    private String mfg_id;
    private String service_uuid;
    private String rssi;

    public URLEntity() {
    }

    public URLEntity(String url, String ids, String power, String mfg_id, String service_uuid, String rssi) {

        this.uri = url;
        this.ids = ids;
        this.power = power;
        this.mfg_id = mfg_id;
        this.service_uuid = service_uuid;
        this.rssi = rssi;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getMfg_id() {
        return mfg_id;
    }

    public void setMfg_id(String mfg_id) {
        this.mfg_id = mfg_id;
    }

    public String getService_uuid() {
        return service_uuid;
    }

    public void setService_uuid(String service_uuid) {
        this.service_uuid = service_uuid;
    }

    public String getRssi() {
        return rssi;
    }

    public void setRssi(String rssi) {
        this.rssi = rssi;
    }

    @Override
    public boolean equals(Object object) {
        return (
                (object != null)
                        &&
                        (object instanceof URLEntity)
                        &&
                        (this.ids.equals(((URLEntity) object).getIds()))
        );
    }

    @Override
    public int hashCode() {
        return ids.hashCode();
    }
}
