package org.experiment.rest;

import org.experiment.Application;
import org.experiment.base.AbstractRestServiceControllerTest;
import org.experiment.extensions.annotation.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by sepetean on 11/2/2015.
 */
    //use gradle task test -Dspring.profiles.active=devh2
//@ActiveProfiles(EnvironmentUtilsLocal.DEV_H2)
    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringApplicationConfiguration(classes = Application.class)
    @WebAppConfiguration
    public class JPARestServiceControllerTest extends AbstractRestServiceControllerTest {

        @Log Logger log;

        @Test
        public void select() throws Exception{
            String profileName = activeProfile.getProfileName();
            log.info(profileName);
            ResultActions andExpect = mvc.perform(get("/jpa/select/" + profileName)).andExpect(status().is2xxSuccessful());
            String contentAsString = andExpect.andReturn().getResponse().getContentAsString();

            log.info(contentAsString);
        }

    }