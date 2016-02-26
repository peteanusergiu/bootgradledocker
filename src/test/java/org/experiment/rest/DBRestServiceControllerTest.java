package org.experiment.rest;

import org.experiment.Application;
import org.experiment.base.AbstractRestServiceControllerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
    public class DBRestServiceControllerTest extends AbstractRestServiceControllerTest {

        @Test
        public void delete() throws Exception {
            mvc.perform(get("/db/delete/")).andExpect(status().is2xxSuccessful());
        }

    }