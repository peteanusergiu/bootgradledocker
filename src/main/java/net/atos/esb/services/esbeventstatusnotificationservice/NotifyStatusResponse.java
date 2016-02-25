
package net.atos.esb.services.esbeventstatusnotificationservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import net.atos.esb.schemas.common.HeaderRequiredDestinationType;
import net.atos.esb.schemas.common.ReturnType;


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
 *         &lt;element name="header" type="{http://esb.atos.net/schemas/common}headerRequiredDestinationType" form="unqualified"/>
 *         &lt;element name="return" type="{http://esb.atos.net/schemas/common}returnType" form="unqualified"/>
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
    "_return"
})
@XmlRootElement(name = "notifyStatusResponse")
public class NotifyStatusResponse {

    @XmlElement(required = true)
    protected HeaderRequiredDestinationType header;
    @XmlElement(name = "return", required = true)
    protected ReturnType _return;

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
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnType }
     *     
     */
    public ReturnType getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnType }
     *     
     */
    public void setReturn(ReturnType value) {
        this._return = value;
    }

}
