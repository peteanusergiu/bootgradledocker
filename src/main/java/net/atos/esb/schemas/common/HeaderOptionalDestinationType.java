
package net.atos.esb.schemas.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for headerOptionalDestinationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="headerOptionalDestinationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://esb.atos.net/schemas/common}headerBaseType">
 *       &lt;sequence>
 *         &lt;element name="dstApplicationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "headerOptionalDestinationType", propOrder = {
    "dstApplicationID"
})
public class HeaderOptionalDestinationType
    extends HeaderBaseType
{

    protected String dstApplicationID;

    /**
     * Gets the value of the dstApplicationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDstApplicationID() {
        return dstApplicationID;
    }

    /**
     * Sets the value of the dstApplicationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDstApplicationID(String value) {
        this.dstApplicationID = value;
    }

}
