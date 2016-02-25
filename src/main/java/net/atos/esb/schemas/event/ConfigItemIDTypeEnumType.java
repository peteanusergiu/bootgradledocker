
package net.atos.esb.schemas.event;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for configItemIDTypeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="configItemIDTypeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CIID"/>
 *     &lt;enumeration value="CONFIG_NAME"/>
 *     &lt;enumeration value="ASSET_ID"/>
 *     &lt;enumeration value="EVENT_CI"/>
 *     &lt;enumeration value="EXT_ID"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "configItemIDTypeEnumType")
@XmlEnum
public enum ConfigItemIDTypeEnumType {

    CIID,
    CONFIG_NAME,
    ASSET_ID,
    EVENT_CI,
    EXT_ID,
    NONE;

    public String value() {
        return name();
    }

    public static ConfigItemIDTypeEnumType fromValue(String v) {
        return valueOf(v);
    }

}
