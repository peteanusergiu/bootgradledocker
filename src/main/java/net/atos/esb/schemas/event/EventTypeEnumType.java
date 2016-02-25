
package net.atos.esb.schemas.event;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eventTypeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eventTypeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AVAILABILITY"/>
 *     &lt;enumeration value="PERFORMANCE"/>
 *     &lt;enumeration value="HEARTBEAT"/>
 *     &lt;enumeration value="OUTAGE"/>
 *     &lt;enumeration value="CLIENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eventTypeEnumType")
@XmlEnum
public enum EventTypeEnumType {

    AVAILABILITY,
    PERFORMANCE,
    HEARTBEAT,
    OUTAGE,
    CLIENT;

    public String value() {
        return name();
    }

    public static EventTypeEnumType fromValue(String v) {
        return valueOf(v);
    }

}
