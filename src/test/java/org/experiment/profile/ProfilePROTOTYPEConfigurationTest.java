package org.experiment.profile;

import org.experiment.Application;
import org.experiment.base.AbstractRestServiceControllerTest;
import org.experiment.util.EnvironmentUtilsLocal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles(EnvironmentUtilsLocal.PROTOTYPE)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ProfilePROTOTYPEConfigurationTest extends AbstractRestServiceControllerTest {
	
	@Test
	public void testSayHelloActiveProfile() throws Exception{
		String profileName = activeProfile.getProfileName();
		System.out.println(profileName);
		ResultActions andExpect = mvc.perform(get("/hello/world/visitor/" + profileName)).andExpect(status().is2xxSuccessful());
		String contentAsString = andExpect.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}

}
