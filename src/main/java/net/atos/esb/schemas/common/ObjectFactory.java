
package net.atos.esb.schemas.common;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.atos.esb.schemas.common package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.atos.esb.schemas.common
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReturnType }
     * 
     */
    public ReturnType createReturnType() {
        return new ReturnType();
    }

    /**
     * Create an instance of {@link HeaderBaseType }
     * 
     */
    public HeaderBaseType createHeaderBaseType() {
        return new HeaderBaseType();
    }

    /**
     * Create an instance of {@link HeaderRequiredDestinationType }
     * 
     */
    public HeaderRequiredDestinationType createHeaderRequiredDestinationType() {
        return new HeaderRequiredDestinationType();
    }

    /**
     * Create an instance of {@link HeaderOptionalDestinationType }
     * 
     */
    public HeaderOptionalDestinationType createHeaderOptionalDestinationType() {
        return new HeaderOptionalDestinationType();
    }

    /**
     * Create an instance of {@link AuthenticationType }
     * 
     */
    public AuthenticationType createAuthenticationType() {
        return new AuthenticationType();
    }

}
