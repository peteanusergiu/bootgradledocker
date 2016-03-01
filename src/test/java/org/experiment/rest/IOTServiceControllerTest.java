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
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//use gradle task test -Dspring.profiles.active=devh2
// and import
//@ActiveProfiles(EnvironmentUtilsLocal.DEV_H2)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class IOTServiceControllerTest extends AbstractRestServiceControllerTest {

    @Test
    public void testPersistIOTFull() throws Exception {
        String profileName = activeProfile.getProfileName();
        System.out.println(profileName);
        ResultActions andExpect = mvc.perform(
                post("/soap/iot")
                        .contentType(MediaType.APPLICATION_XML_VALUE)
                        .content(writeValueAsXMLString(createIOTFull()))
        ).andExpect(status().is2xxSuccessful());

        String contentAsString = andExpect.andReturn().getResponse().getContentAsString();

        System.out.println(contentAsString);
    }
    @Test
    public void testPersistIOTTLMS() throws Exception {
        String profileName = activeProfile.getProfileName();
        System.out.println(profileName);
        ResultActions andExpect = mvc.perform(
                post("/soap/iot")
                        .contentType(MediaType.APPLICATION_XML_VALUE)
                        .content(writeValueAsXMLString(createIOTTLMS()))
        ).andExpect(status().is2xxSuccessful());

        String contentAsString = andExpect.andReturn().getResponse().getContentAsString();

        System.out.println(contentAsString);
    }

    private IOT createIOTFull() {
        List<TLM> tlms = new ArrayList<>();
        tlms.add(new TLM("voltage", "temp", "pdus", "seconds"));
        tlms.add(new TLM("voltage2", "temp2", "pdus2", "seconds2"));
        TLMS tlmsList = new TLMS(tlms);
        List<UID> uidsList = new ArrayList<>();
        uidsList.add(new UID("id_namespace", "id_instance", "1", "2", "3", "4", "5", "6", "7"));
        UIDS uids = new UIDS(uidsList);
        List<URL> urlList = new ArrayList<>();
        urlList.add(new URL("url", "2", "3", "4", "5", "6"));
        URLS urls = new URLS(urlList);
        Eddystone beacon = new Eddystone(uids, tlmsList, urls);
        return new IOT(beacon, "test:Mac", "eddy");
    }

    private IOT createIOTTLMS() {
        List<TLM> tlms = new ArrayList<>();
        tlms.add(new TLM("voltage", "temp", "pdus", "seconds"));
        tlms.add(new TLM("voltage2", "temp2", "pdus2", "seconds2"));
        TLMS tlmsList = new TLMS(tlms);
        UIDS uids = new UIDS();
        URLS urls = new URLS();
        Eddystone beacon = new Eddystone(uids, tlmsList, urls);
        return new IOT(beacon, "test:Mac", "eddy");
    }

    private String writeValueAsXMLString(Object object) {
        String result = ObjectMapping.serialize(object, MediaType.APPLICATION_XML_VALUE, StandardCharsets.UTF_8.toString(), ObjectMapperType.JAXB, ObjectMapperConfig.objectMapperConfig());
        System.out.println(result);
        return result;
    }

}
