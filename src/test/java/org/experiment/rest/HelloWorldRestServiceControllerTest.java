package org.experiment.rest;

import com.jayway.restassured.config.ObjectMapperConfig;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.internal.mapping.ObjectMapping;
import net.atos.esb.schemas.event.EventKeyType;
import net.atos.esb.schemas.event.EventType;
import net.atos.esb.services.esbeventservice.CreateEvent;
import org.experiment.Application;
import org.experiment.base.AbstractRestServiceControllerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//use gradle task test -Dspring.profiles.active=devh2l
// and import
//@ActiveProfiles(EnvironmentUtils.DEV_H2)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class HelloWorldRestServiceControllerTest extends AbstractRestServiceControllerTest {

    /*demo example on how to communicate a GET HTTP verb, with a RESTfull service using MockMvc utility class*/
	@Test
	public void testSayHello() throws Exception{
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
	public void testSayHelloSOAP() throws Exception{
		String profileName = activeProfile.getProfileName();
		System.out.println(profileName);
		ResultActions andExpect = mvc.perform(
                    post("/hello/soap/")
                            .contentType(MediaType.APPLICATION_XML_VALUE)
                            .content(writeValueAsXMLString(createEvent()))
        ).andExpect(status().is2xxSuccessful());

		String contentAsString = andExpect.andReturn().getResponse().getContentAsString();

		System.out.println(contentAsString);
	}

    private CreateEvent createEvent() {
        CreateEvent result = new CreateEvent();
			EventType eventType = new EventType();
				EventKeyType eventKeyValue = new EventKeyType();
				eventKeyValue.setEventID("eventKeyDemo");
		eventType.setEventKey(eventKeyValue);
		result.setEvent(eventType);
        return result;
    }

    private String writeValueAsXMLString(Object object){
		return ObjectMapping.serialize(object, MediaType.APPLICATION_XML_VALUE, StandardCharsets.UTF_8.toString(), ObjectMapperType.JAXB, ObjectMapperConfig.objectMapperConfig());
	}

}
