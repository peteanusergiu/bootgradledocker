package org.experiment.util.restclient;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by petea on 5/25/2016.
 */
public class RestTemplateClientBuilder {


    public static RestTemplate buildJsonRestClient() {
        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Add the JSON message converter
        restTemplate.getMessageConverters().clear();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate;
    }

    public static RestTemplate buildXMLRestClient() {
        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Add the XML message converter
        restTemplate.getMessageConverters().add(new MappingJackson2XmlHttpMessageConverter());
        return restTemplate;
    }
}
