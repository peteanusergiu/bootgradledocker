package org.experiment.util.mappers;

import com.jayway.restassured.config.ObjectMapperConfig;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.internal.mapping.ObjectMapping;

import java.nio.charset.StandardCharsets;

/**
 * Created by petea on 2/27/2016.
 */
public class CustomObjectMapper {

    /**
     * Writes an entity (XML, JSON, ...) as a String
     *
     * @param object           - the object/entity that needs to be view as a string
     * @param mediaType        - object's structure [MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,...]
     * @param standardCharsets - used charset [StandardCharsets.UTF_8.toString(), ...]
     * @param objectMapperType - used charset [ObjectMapperType.JAXB, ...]
     * @return - string representation
     */
    private static String writeObjectAsString(Object object, String mediaType, StandardCharsets standardCharsets, ObjectMapperType objectMapperType) {
        return ObjectMapping.serialize(object, mediaType, standardCharsets.toString(), objectMapperType, ObjectMapperConfig.objectMapperConfig());
    }

    /**
     * Writes an entity (XML, JSON, ...) as a String - short version with default values
     *
     * @param object    - the object/entity that needs to be view as a string
     * @param mediaType - object's structure [MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,...]
     * @return - string representation
     */
    private static String writeObjectAsString(Object object, String mediaType) {
        return ObjectMapping.serialize(object, mediaType,
                StandardCharsets.UTF_8.toString(), ObjectMapperType.JAXB, ObjectMapperConfig.objectMapperConfig());
    }

    /**
     * Writes an entity (XML, JSON, ...) from a String
     *
     * @param object           - the object/entity that needs to be view as a string
     * @param mediaType        - object's structure [MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,...]
     * @param standardCharsets - used charset [StandardCharsets.UTF_8.toString(), ...]
     * @param objectMapperType - used charset [ObjectMapperType.JAXB, ...]
     * @return - string representation
     */
    /*private static String writeStringAsObject(Object object, String mediaType, StandardCharsets standardCharsets, ObjectMapperType objectMapperType) {
        return ObjectMapping.deserialize(object, mediaType, standardCharsets.toString(), objectMapperType, ObjectMapperConfig.objectMapperConfig());
    }*/

    /**
     * Writes an entity (XML, JSON, ...) from a String - short version with default values
     *
     * @param object    - the object/entity that needs to be view as a string
     * @param mediaType - object's structure [MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,...]
     * @return - string representation
     */
    /*private static String writeStringAsObject(Object object, String mediaType) {
        return ObjectMapping.serialize(object, mediaType,
                StandardCharsets.UTF_8.toString(), ObjectMapperType.JAXB, ObjectMapperConfig.objectMapperConfig());
    }*/
}
