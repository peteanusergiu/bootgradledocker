package org.experiment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.experiment.lang.ProfileBean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RestServiceControllerTest {
	
	@Autowired
	protected ProfileBean activeProfile;

	@Autowired
	private WebApplicationContext webAppContext;
	
	protected MockMvc mvc;
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void testSayHello() throws Exception{
		mvc.perform(get("/hello/world/visitor/sergiu")).andExpect(status().is2xxSuccessful());
	}
	
}
