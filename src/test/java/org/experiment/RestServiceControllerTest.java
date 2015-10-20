package org.experiment;

import org.experiment.base.AbstractRestServiceControllerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ActiveProfiles(EnvironmentUtils.DEV_H2)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RestServiceControllerTest extends AbstractRestServiceControllerTest {
	
	@Test
	public void testSayHello() throws Exception{
		mvc.perform(get("/hello/world/visitor/sergiu")).andExpect(status().is2xxSuccessful());
	}
	
}
