
package net.atos.esb.services.esbeventstatusnotificationservice;

import net.atos.esb.schemas.common.HeaderRequiredDestinationType;
import net.atos.esb.schemas.event.EventStatusNotificationType;

import javax.xml.bind.annotation.*;


/**
 * A supporting system (e.g.
 *                             SIA) uses this service to notify the ESB
 *                             about the status of a current event
 *                             (ticket). An originating system provides the
 *                             same service (same WSDL) so that ESB can
 *                             forward the notification to it.
 *                         
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="header" type="{http://esb.atos.net/schemas/common}headerRequiredDestinationType" form="unqualified"/>
 *         &lt;element name="eventStatus" type="{http://esb.atos.net/schemas/event}eventStatusNotificationType" form="unqualified"/>
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
    "eventStatus"
})
@XmlRootElement(name = "notifyStatus")
public class NotifyStatus {

    @XmlElement(required = true)
    protected HeaderRequiredDestinationType header;
    @XmlElement(required = true)
    protected EventStatusNotificationType eventStatus;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderRequiredDestinationType }
     *     
     */
    public HeaderRequiredDestinationType getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderRequiredDestinationType }
     *     
     */
    public void setHeader(HeaderRequiredDestinationType value) {
        this.header = value;
    }

    /**
     * Gets the value of the eventStatus property.
     * 
     * @return
     *     possible object is
     *     {@link EventStatusNotificationType }
     *     
     */
    public EventStatusNotificationType getEventStatus() {
        return eventStatus;
    }

    /**
     * Sets the value of the eventStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventStatusNotificationType }
     *     
     */
    public void setEventStatus(EventStatusNotificationType value) {
        this.eventStatus = value;
    }

}
