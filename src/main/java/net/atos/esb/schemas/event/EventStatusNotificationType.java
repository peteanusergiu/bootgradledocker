
package net.atos.esb.schemas.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eventStatusNotificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eventStatusNotificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eventKey" type="{http://esb.atos.net/schemas/event}eventKeyType"/>
 *         &lt;element name="eventTime" type="{http://esb.atos.net/schemas/event}eventTimeType"/>
 *         &lt;element name="statusType" type="{http://esb.atos.net/schemas/event}troubleTicketStatusEnumType"/>
 *         &lt;element name="statusCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="troubleTicketID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "eventStatusNotificationType", propOrder = {
    "eventKey",
    "eventTime",
    "statusType",
    "statusCode",
    "statusMessage",
    "troubleTicketID",
    "additionalEventAttributes"
})
@XmlRootElement
public class EventStatusNotificationType {

    @XmlElement(required = true)
    protected EventKeyType eventKey;
    @XmlElement(required = true)
    protected EventTimeType eventTime;
    @XmlElement(required = true)
    protected TroubleTicketStatusEnumType statusType;
    @XmlElement(required = true)
    protected String statusCode;
    @XmlElement(required = true)
    protected String statusMessage;
    protected String troubleTicketID;
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
     * Gets the value of the statusType property.
     * 
     * @return
     *     possible object is
     *     {@link TroubleTicketStatusEnumType }
     *     
     */
    public TroubleTicketStatusEnumType getStatusType() {
        return statusType;
    }

    /**
     * Sets the value of the statusType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TroubleTicketStatusEnumType }
     *     
     */
    public void setStatusType(TroubleTicketStatusEnumType value) {
        this.statusType = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the statusMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * Sets the value of the statusMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusMessage(String value) {
        this.statusMessage = value;
    }

    /**
     * Gets the value of the troubleTicketID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTroubleTicketID() {
        return troubleTicketID;
    }

    /**
     * Sets the value of the troubleTicketID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTroubleTicketID(String value) {
        this.troubleTicketID = value;
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
