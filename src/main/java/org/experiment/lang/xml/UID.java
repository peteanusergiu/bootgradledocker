package org.experiment.lang.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class UID extends EddystoneBase {
    protected String id_namespace;
    protected String id_instance;

    public String getId_namespace() {
        return id_namespace;
    }

    public void setId_namespace(String id_namespace) {
        this.id_namespace = id_namespace;
    }

    public String getId_instance() {
        return id_instance;
    }

    public void setId_instance(String id_instance) {
        this.id_instance = id_instance;
    }
}
