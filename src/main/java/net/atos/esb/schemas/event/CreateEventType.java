
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
 * &lt;complexType name="CreateEventType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statusNotification" type="{http://esb.atos.net/schemas/event}eventKeyType"/>
 *         &lt;element name="EventType" type="{http://esb.atos.net/schemas/event}eventType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createEventType", propOrder = {
    "statusNotification",
    "eventType",
})
@XmlRootElement(name="createEventType")
public class CreateEventType {

    @XmlElement(required = true)
    protected StatusNotificationSubscriptionEnumType statusNotification;
    @XmlElement(required = true)
    protected EventType eventType;
    
    /**
     * Gets the value of the StatusNotificationSubscriptionEnumType property.
     * 
     * @return
     *     possible object is
     *     {@link StatusNotificationSubscriptionEnumType }
     *     
     */
    public StatusNotificationSubscriptionEnumType getStatusNotification() {
        return statusNotification;
    }

    /**
     * Sets the value of the StatusNotificationSubscriptionEnumType property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusNotificationSubscriptionEnumType }
     *     
     */
    public void setStatusNotification(StatusNotificationSubscriptionEnumType value) {
        this.statusNotification = value;
    }
    /**
     * Gets the value of the eventKey property.
     * 
     * @return
     *     possible object is
     *     {@link EventKeyType }
     *     
     */
    public EventType getEventType() {
	return eventType;
    }
    
    /**
     * Sets the value of the eventKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventKeyType }
     *     
     */
    public void setEventType(EventType value) {
	this.eventType = value;
    }

    @Override
    public String toString() {
	return  this.eventType.toString();
    }
}
