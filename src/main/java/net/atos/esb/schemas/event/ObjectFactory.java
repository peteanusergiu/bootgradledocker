
package net.atos.esb.schemas.event;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.atos.esb.schemas.event package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.atos.esb.schemas.event
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EventType }
     * 
     */
    public EventType createEventType() {
        return new EventType();
    }

    /**
     * Create an instance of {@link AdditionalEventAttributesType }
     * 
     */
    public AdditionalEventAttributesType createAdditionalEventAttributesType() {
        return new AdditionalEventAttributesType();
    }

    /**
     * Create an instance of {@link EventKeyType }
     * 
     */
    public EventKeyType createEventKeyType() {
        return new EventKeyType();
    }

    /**
     * Create an instance of {@link TroubleTicketType }
     * 
     */
    public TroubleTicketType createTroubleTicketType() {
        return new TroubleTicketType();
    }

    /**
     * Create an instance of {@link ConfigItemIDType }
     * 
     */
    public ConfigItemIDType createConfigItemIDType() {
        return new ConfigItemIDType();
    }

    /**
     * Create an instance of {@link EventResolveType }
     * 
     */
    public EventResolveType createEventResolveType() {
        return new EventResolveType();
    }

    /**
     * Create an instance of {@link AdditionalEventAttributeType }
     * 
     */
    public AdditionalEventAttributeType createAdditionalEventAttributeType() {
        return new AdditionalEventAttributeType();
    }

    /**
     * Create an instance of {@link EventStatusNotificationType }
     * 
     */
    public EventStatusNotificationType createEventStatusNotificationType() {
        return new EventStatusNotificationType();
    }

    /**
     * Create an instance of {@link EventClassType }
     * 
     */
    public EventClassType createEventClassType() {
        return new EventClassType();
    }

    /**
     * Create an instance of {@link EventUpdateType }
     * 
     */
    public EventUpdateType createEventUpdateType() {
        return new EventUpdateType();
    }

    /**
     * Create an instance of {@link EventTimeType }
     * 
     */
    public EventTimeType createEventTimeType() {
        return new EventTimeType();
    }

}
