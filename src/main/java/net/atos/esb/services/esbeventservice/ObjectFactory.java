
package net.atos.esb.services.esbeventservice;

import net.atos.esb.schemas.common.ReturnType;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.atos.esb.services.esbeventservice package. 
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

    private final static QName _CreateEventFault_QNAME = new QName("http://esb.atos.net/services/ESBEventService/", "createEventFault");
    private final static QName _UpdateEventFault_QNAME = new QName("http://esb.atos.net/services/ESBEventService/", "updateEventFault");
    private final static QName _ResolveEventFault_QNAME = new QName("http://esb.atos.net/services/ESBEventService/", "resolveEventFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.atos.esb.services.esbeventservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateEventResponse }
     * 
     */
    public UpdateEventResponse createUpdateEventResponse() {
        return new UpdateEventResponse();
    }

    /**
     * Create an instance of {@link ResolveEvent }
     * 
     */
    public ResolveEvent createResolveEvent() {
        return new ResolveEvent();
    }

    /**
     * Create an instance of {@link CreateEventResponse }
     * 
     */
    public CreateEventResponse createCreateEventResponse() {
        return new CreateEventResponse();
    }

    /**
     * Create an instance of {@link CreateEvent }
     * 
     */
    public CreateEvent createCreateEvent() {
        return new CreateEvent();
    }

    /**
     * Create an instance of {@link ResolveEventResponse }
     * 
     */
    public ResolveEventResponse createResolveEventResponse() {
        return new ResolveEventResponse();
    }

    /**
     * Create an instance of {@link UpdateEvent }
     * 
     */
    public UpdateEvent createUpdateEvent() {
        return new UpdateEvent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://esb.atos.net/services/ESBEventService/", name = "createEventFault")
    public JAXBElement<ReturnType> createCreateEventFault(ReturnType value) {
        return new JAXBElement<ReturnType>(_CreateEventFault_QNAME, ReturnType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://esb.atos.net/services/ESBEventService/", name = "updateEventFault")
    public JAXBElement<ReturnType> createUpdateEventFault(ReturnType value) {
        return new JAXBElement<ReturnType>(_UpdateEventFault_QNAME, ReturnType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://esb.atos.net/services/ESBEventService/", name = "resolveEventFault")
    public JAXBElement<ReturnType> createResolveEventFault(ReturnType value) {
        return new JAXBElement<ReturnType>(_ResolveEventFault_QNAME, ReturnType.class, null, value);
    }

}
