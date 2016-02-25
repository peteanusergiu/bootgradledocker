
package net.atos.esb.schemas.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for troubleTicketType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="troubleTicketType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="priority" type="{http://esb.atos.net/schemas/event}troubleTicketPriorityEnumType" minOccurs="0"/>
 *         &lt;element name="workgroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "troubleTicketType", propOrder = {
    "priority",
    "workgroup",
    "category"
})
public class TroubleTicketType {

    protected TroubleTicketPriorityEnumType priority;
    protected String workgroup;
    protected String category;

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link TroubleTicketPriorityEnumType }
     *     
     */
    public TroubleTicketPriorityEnumType getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link TroubleTicketPriorityEnumType }
     *     
     */
    public void setPriority(TroubleTicketPriorityEnumType value) {
        this.priority = value;
    }

    /**
     * Gets the value of the workgroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkgroup() {
        return workgroup;
    }

    /**
     * Sets the value of the workgroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkgroup(String value) {
        this.workgroup = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

}
