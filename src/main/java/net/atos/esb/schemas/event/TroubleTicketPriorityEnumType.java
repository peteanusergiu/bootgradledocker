
package net.atos.esb.schemas.event;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for troubleTicketPriorityEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="troubleTicketPriorityEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="High"/>
 *     &lt;enumeration value="Medium"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "troubleTicketPriorityEnumType")
@XmlEnum
public enum TroubleTicketPriorityEnumType {

    @XmlEnumValue("High")
    HIGH("High"),
    @XmlEnumValue("Medium")
    MEDIUM("Medium");
    private final String value;

    TroubleTicketPriorityEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TroubleTicketPriorityEnumType fromValue(String v) {
        for (TroubleTicketPriorityEnumType c: TroubleTicketPriorityEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
