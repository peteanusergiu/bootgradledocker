package org.experiment.base;

import org.experiment.lang.json.ProfileBean;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by sepetean on 10/19/2015.
 */
public class AbstractRestServiceControllerTest {
    @Autowired
    protected ProfileBean activeProfile;

    @Autowired
    protected WebApplicationContext webAppContext;

    protected MockMvc mvc;

    @Before
    public void setup(){

        mvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();

    }
}