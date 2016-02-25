package org.experiment.lang.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Eddystone {

    @XmlElement
    protected List<UID> uids;
    @XmlElement
    protected List<TLM> tlms;
    @XmlElement
    protected List<URL> urls;


    public List<URL> getUrls() {
        return urls;
    }

    public void setUrls(List<URL> urls) {
        this.urls = urls;
    }

    public List<UID> getUids() {
        return uids;
    }

    public void setUids(List<UID> uids) {
        this.uids = uids;
    }

    public List<TLM> getTlms() {
        return tlms;
    }

    public void setTlms(List<TLM> tlms) {
        this.tlms = tlms;
    }
}
