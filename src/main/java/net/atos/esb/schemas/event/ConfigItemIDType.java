
package net.atos.esb.schemas.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Identifier for affected Configuration Item (CI).
 *             
 * 
 * <p>Java class for configItemIDType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="configItemIDType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idType" type="{http://esb.atos.net/schemas/event}configItemIDTypeEnumType"/>
 *         &lt;element name="configItemSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "configItemIDType", propOrder = {
    "id",
    "idType",
    "configItemSource"
})
public class ConfigItemIDType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected ConfigItemIDTypeEnumType idType;
    protected String configItemSource;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the idType property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigItemIDTypeEnumType }
     *     
     */
    public ConfigItemIDTypeEnumType getIdType() {
        return idType;
    }

    /**
     * Sets the value of the idType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigItemIDTypeEnumType }
     *     
     */
    public void setIdType(ConfigItemIDTypeEnumType value) {
        this.idType = value;
    }

    /**
     * Gets the value of the configItemSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigItemSource() {
        return configItemSource;
    }

    /**
     * Sets the value of the configItemSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigItemSource(String value) {
        this.configItemSource = value;
    }

}
