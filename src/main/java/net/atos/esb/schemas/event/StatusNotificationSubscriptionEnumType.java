
package net.atos.esb.schemas.event;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statusNotificationSubscriptionEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="statusNotificationSubscriptionEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALWAYS"/>
 *     &lt;enumeration value="RESOLVE"/>
 *     &lt;enumeration value="NEVER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "statusNotificationSubscriptionEnumType")
@XmlEnum
public enum StatusNotificationSubscriptionEnumType {

    ALWAYS,
    RESOLVE,

    /**
     * Default value
     * 
     */
    NEVER;

    public String value() {
        return name();
    }

    public static StatusNotificationSubscriptionEnumType fromValue(String v) {
        return valueOf(v);
    }

}
