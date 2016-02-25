
package net.atos.esb.services.esbeventservice;

import net.atos.esb.schemas.common.HeaderOptionalDestinationType;
import net.atos.esb.schemas.event.EventType;
import net.atos.esb.schemas.event.StatusNotificationSubscriptionEnumType;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="header" type="{http://esb.atos.net/schemas/common}headerOptionalDestinationType" form="unqualified"/>
 *         &lt;element name="statusNotificationSubscription" type="{http://esb.atos.net/schemas/event}statusNotificationSubscriptionEnumType" form="unqualified"/>
 *         &lt;element name="event" type="{http://esb.atos.net/schemas/event}eventType" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "statusNotificationSubscription",
    "event"
})
@XmlRootElement(name = "createEvent")
public class CreateEvent {

    @XmlElement(required = true)
    protected HeaderOptionalDestinationType header;
    @XmlElement(required = true)
    protected StatusNotificationSubscriptionEnumType statusNotificationSubscription;
    @XmlElement(required = true)
    protected EventType event;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderOptionalDestinationType }
     *     
     */
    public HeaderOptionalDestinationType getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderOptionalDestinationType }
     *     
     */
    public void setHeader(HeaderOptionalDestinationType value) {
        this.header = value;
    }

    /**
     * Gets the value of the statusNotificationSubscription property.
     * 
     * @return
     *     possible object is
     *     {@link StatusNotificationSubscriptionEnumType }
     *     
     */
    public StatusNotificationSubscriptionEnumType getStatusNotificationSubscription() {
        return statusNotificationSubscription;
    }

    /**
     * Sets the value of the statusNotificationSubscription property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusNotificationSubscriptionEnumType }
     *     
     */
    public void setStatusNotificationSubscription(StatusNotificationSubscriptionEnumType value) {
        this.statusNotificationSubscription = value;
    }

    /**
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link EventType }
     *     
     */
    public EventType getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventType }
     *     
     */
    public void setEvent(EventType value) {
        this.event = value;
    }

}
