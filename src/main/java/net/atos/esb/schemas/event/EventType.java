
package net.atos.esb.schemas.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eventType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eventType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eventKey" type="{http://esb.atos.net/schemas/event}eventKeyType"/>
 *         &lt;element name="eventTime" type="{http://esb.atos.net/schemas/event}eventTimeType"/>
 *         &lt;element name="eventClass" type="{http://esb.atos.net/schemas/event}eventClassType"/>
 *         &lt;element name="configItemID" type="{http://esb.atos.net/schemas/event}configItemIDType"/>
 *         &lt;element name="troubleTicket" type="{http://esb.atos.net/schemas/event}troubleTicketType"/>
 *         &lt;element name="additionalEventAttributes" type="{http://esb.atos.net/schemas/event}additionalEventAttributesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eventType", propOrder = {
    "eventKey",
    "eventTime",
    "eventClass",
    "configItemID",
    "troubleTicket",
    "additionalEventAttributes"
})
@XmlRootElement(name="eventType")
public class EventType {

    @XmlElement(required = true)
    protected EventKeyType eventKey;
    @XmlElement(required = true)
    protected EventTimeType eventTime;
    @XmlElement(required = true)
    protected EventClassType eventClass;
    @XmlElement(required = true)
    protected ConfigItemIDType configItemID;
    @XmlElement(required = true)
    protected TroubleTicketType troubleTicket;
    protected AdditionalEventAttributesType additionalEventAttributes;

    /**
     * Gets the value of the eventKey property.
     * 
     * @return
     *     possible object is
     *     {@link EventKeyType }
     *     
     */
    public EventKeyType getEventKey() {
        return eventKey;
    }

    /**
     * Sets the value of the eventKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventKeyType }
     *     
     */
    public void setEventKey(EventKeyType value) {
        this.eventKey = value;
    }

    /**
     * Gets the value of the eventTime property.
     * 
     * @return
     *     possible object is
     *     {@link EventTimeType }
     *     
     */
    public EventTimeType getEventTime() {
        return eventTime;
    }

    /**
     * Sets the value of the eventTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventTimeType }
     *     
     */
    public void setEventTime(EventTimeType value) {
        this.eventTime = value;
    }

    /**
     * Gets the value of the eventClass property.
     * 
     * @return
     *     possible object is
     *     {@link EventClassType }
     *     
     */
    public EventClassType getEventClass() {
        return eventClass;
    }

    /**
     * Sets the value of the eventClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventClassType }
     *     
     */
    public void setEventClass(EventClassType value) {
        this.eventClass = value;
    }

    /**
     * Gets the value of the configItemID property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigItemIDType }
     *     
     */
    public ConfigItemIDType getConfigItemID() {
        return configItemID;
    }

    /**
     * Sets the value of the configItemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigItemIDType }
     *     
     */
    public void setConfigItemID(ConfigItemIDType value) {
        this.configItemID = value;
    }

    /**
     * Gets the value of the troubleTicket property.
     * 
     * @return
     *     possible object is
     *     {@link TroubleTicketType }
     *     
     */
    public TroubleTicketType getTroubleTicket() {
        return troubleTicket;
    }

    /**
     * Sets the value of the troubleTicket property.
     * 
     * @param value
     *     allowed object is
     *     {@link TroubleTicketType }
     *     
     */
    public void setTroubleTicket(TroubleTicketType value) {
        this.troubleTicket = value;
    }

    /**
     * Gets the value of the additionalEventAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalEventAttributesType }
     *     
     */
    public AdditionalEventAttributesType getAdditionalEventAttributes() {
        return additionalEventAttributes;
    }

    /**
     * Sets the value of the additionalEventAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalEventAttributesType }
     *     
     */
    public void setAdditionalEventAttributes(AdditionalEventAttributesType value) {
        this.additionalEventAttributes = value;
    }

}
