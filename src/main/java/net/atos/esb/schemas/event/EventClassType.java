
package net.atos.esb.schemas.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Event classification
 * 
 * <p>Java class for eventClassType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eventClassType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eventType" type="{http://esb.atos.net/schemas/event}eventTypeEnumType"/>
 *         &lt;element name="eventSenderType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="eventClass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="eventSeverity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventHostname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventMessageText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eventClassType", propOrder = {
    "eventType",
    "eventSenderType",
    "eventClass",
    "eventSeverity",
    "eventHostname",
    "eventMessageText"
})
public class EventClassType {

    @XmlElement(required = true)
    protected EventTypeEnumType eventType;
    @XmlElement(required = true)
    protected String eventSenderType;
    @XmlElement(required = true)
    protected String eventClass;
    protected String eventSeverity;
    protected String eventHostname;
    @XmlElement(required = true)
    protected String eventMessageText;

    /**
     * Gets the value of the eventType property.
     * 
     * @return
     *     possible object is
     *     {@link EventTypeEnumType }
     *     
     */
    public EventTypeEnumType getEventType() {
        return eventType;
    }

    /**
     * Sets the value of the eventType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventTypeEnumType }
     *     
     */
    public void setEventType(EventTypeEnumType value) {
        this.eventType = value;
    }

    /**
     * Gets the value of the eventSenderType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventSenderType() {
        return eventSenderType;
    }

    /**
     * Sets the value of the eventSenderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventSenderType(String value) {
        this.eventSenderType = value;
    }

    /**
     * Gets the value of the eventClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventClass() {
        return eventClass;
    }

    /**
     * Sets the value of the eventClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventClass(String value) {
        this.eventClass = value;
    }

    /**
     * Gets the value of the eventSeverity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventSeverity() {
        return eventSeverity;
    }

    /**
     * Sets the value of the eventSeverity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventSeverity(String value) {
        this.eventSeverity = value;
    }

    /**
     * Gets the value of the eventHostname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventHostname() {
        return eventHostname;
    }

    /**
     * Sets the value of the eventHostname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventHostname(String value) {
        this.eventHostname = value;
    }

    /**
     * Gets the value of the eventMessageText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventMessageText() {
        return eventMessageText;
    }

    /**
     * Sets the value of the eventMessageText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventMessageText(String value) {
        this.eventMessageText = value;
    }

}
