package org.experiment.lang.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "iot")
public class IOT {

    @XmlElement(name = "eddystone")
    private Eddystone beacon;

    private String mac;

    private String type;


    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Eddystone getBeacon() {
        return beacon;
    }

    public void setBeacon(Eddystone beacon) {
        this.beacon = beacon;
    }

}
