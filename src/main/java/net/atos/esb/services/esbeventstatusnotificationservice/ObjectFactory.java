
package net.atos.esb.services.esbeventstatusnotificationservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import net.atos.esb.schemas.common.ReturnType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.atos.esb.services.esbeventstatusnotificationservice package. 
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

    private final static QName _NotifyStatusFault_QNAME = new QName("http://esb.atos.net/services/ESBEventStatusNotificationService/", "notifyStatusFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.atos.esb.services.esbeventstatusnotificationservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyStatus }
     * 
     */
    public NotifyStatus createNotifyStatus() {
        return new NotifyStatus();
    }

    /**
     * Create an instance of {@link NotifyStatusResponse }
     * 
     */
    public NotifyStatusResponse createNotifyStatusResponse() {
        return new NotifyStatusResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://esb.atos.net/services/ESBEventStatusNotificationService/", name = "notifyStatusFault")
    public JAXBElement<ReturnType> createNotifyStatusFault(ReturnType value) {
        return new JAXBElement<ReturnType>(_NotifyStatusFault_QNAME, ReturnType.class, null, value);
    }

}
