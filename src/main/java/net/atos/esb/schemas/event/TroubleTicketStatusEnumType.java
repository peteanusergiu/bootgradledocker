
package net.atos.esb.schemas.event;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for troubleTicketStatusEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="troubleTicketStatusEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RESOLVE"/>
 *     &lt;enumeration value="TICKET_CREATED"/>
 *     &lt;enumeration value="TICKET_ERROR"/>
 *     &lt;enumeration value="IN_MAINTENANCE"/>
 *     &lt;enumeration value="NO_ROOTCAUSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "troubleTicketStatusEnumType")
@XmlEnum
public enum TroubleTicketStatusEnumType {

    RESOLVE,
    TICKET_CREATED,
    TICKET_ERROR,
    IN_MAINTENANCE,
    NO_ROOTCAUSE;

    public String value() {
        return name();
    }

    public static TroubleTicketStatusEnumType fromValue(String v) {
        return valueOf(v);
    }

}
