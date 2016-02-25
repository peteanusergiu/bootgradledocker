
package net.atos.esb.schemas.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eventUpdateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eventUpdateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eventKey" type="{http://esb.atos.net/schemas/event}eventKeyType"/>
 *         &lt;element name="eventTime" type="{http://esb.atos.net/schemas/event}eventTimeType"/>
 *         &lt;element name="eventType" type="{http://esb.atos.net/schemas/event}eventTypeEnumType"/>
 *         &lt;element name="troubleTicketPriority" type="{http://esb.atos.net/schemas/event}troubleTicketPriorityEnumType" minOccurs="0"/>
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
@XmlType(name = "eventUpdateType", propOrder = {
    "eventKey",
    "eventTime",
    "eventType",
    "troubleTicketPriority",
    "additionalEventAttributes"
})
@XmlRootElement(name="eventUpdateType")
public class EventUpdateType {

    @XmlElement(required = true)
    protected EventKeyType eventKey;
    @XmlElement(required = true)
    protected EventTimeType eventTime;
    @XmlElement(required = true)
    protected EventTypeEnumType eventType;
    protected TroubleTicketPriorityEnumType troubleTicketPriority;
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
     * Gets the value of the troubleTicketPriority property.
     * 
     * @return
     *     possible object is
     *     {@link TroubleTicketPriorityEnumType }
     *     
     */
    public TroubleTicketPriorityEnumType getTroubleTicketPriority() {
        return troubleTicketPriority;
    }

    /**
     * Sets the value of the troubleTicketPriority property.
     * 
     * @param value
     *     allowed object is
     *     {@link TroubleTicketPriorityEnumType }
     *     
     */
    public void setTroubleTicketPriority(TroubleTicketPriorityEnumType value) {
        this.troubleTicketPriority = value;
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
