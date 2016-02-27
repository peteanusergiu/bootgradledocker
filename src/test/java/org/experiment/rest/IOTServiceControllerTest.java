package org.experiment.rest;

import com.jayway.restassured.config.ObjectMapperConfig;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.internal.mapping.ObjectMapping;
import org.experiment.Application;
import org.experiment.base.AbstractRestServiceControllerTest;
import org.experiment.lang.iot.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//use gradle task test -Dspring.profiles.active=devh2
// and import
//@ActiveProfiles(EnvironmentUtilsLocal.DEV_H2)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class IOTServiceControllerTest extends AbstractRestServiceControllerTest {

    /*demo example on how to communicate a GET HTTP verb, with a RESTfull service using MockMvc utility class*/
    @Test
    public void testSayHello() throws Exception {
        String profileName = activeProfile.getProfileName();
        System.out.println(profileName);
        ResultActions andExpect = mvc.perform(get("/hello/world/visitor/" + profileName)).andExpect(status().is2xxSuccessful());
        String contentAsString = andExpect.andReturn().getResponse().getContentAsString();

        System.out.println(contentAsString);
    }

    /*demo example on how to communicate a PUT HTTP verb, with a RESTfull service using MockMvc utility class
    * Interesting is the simulation of an SOAP service using RESTfull service
    *
    * Used libs com.jayway.restassured.internal.mapping from package com.jayway.restassured:rest-assured:2.4.0
    * ObjectMapping - useful approach in converting an object into an XML format
    * see also
    * ObjectMapper.writeValueAsString for an Object2JSON transformation
    * */
    @Test
    public void testSayHelloSOAP() throws Exception {
        String profileName = activeProfile.getProfileName();
        System.out.println(profileName);
        ResultActions andExpect = mvc.perform(
                post("/hello/soap/iot")
                        .contentType(MediaType.APPLICATION_XML_VALUE)
                        .content(writeValueAsXMLString(createIOT()))
        ).andExpect(status().is2xxSuccessful());

        String contentAsString = andExpect.andReturn().getResponse().getContentAsString();

        System.out.println(contentAsString);
    }

    private IOT createIOT() {
        IOT iot = new IOT();
        iot.setMac("test:Mac");
        iot.setType("eddystone");

        Eddystone beacon = new Eddystone();

        List<TLM> tlms = Collections.EMPTY_LIST;
        beacon.setTlms(tlms);
        List<URL> urls = Collections.EMPTY_LIST;
        beacon.setUrls(urls);
        List<UID> uids = Collections.EMPTY_LIST;
        beacon.setUids(uids);

        iot.setBeacon(beacon);

        return iot;
    }

    private String writeValueAsXMLString(Object object) {
        return ObjectMapping.serialize(object, MediaType.APPLICATION_XML_VALUE, StandardCharsets.UTF_8.toString(), ObjectMapperType.JAXB, ObjectMapperConfig.objectMapperConfig());
    }

}
