package org.experiment.lang.iot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@ApiModel(description = "Eddystone's UID frame")
public class UID extends EddystoneBase {
    @XmlElement
    @ApiModelProperty(value = "The beacon's eddystone namespace id")
    @NotNull
    protected String id_namespace;

    @XmlElement
    @ApiModelProperty(value = "The beacon's eddystone namespace instance")
    @NotNull
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
