package org.experiment.profile;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.experiment.RestServiceControllerTest;
import org.experiment.util.EnvironmentUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.servlet.ResultActions;

@Profile(EnvironmentUtils.PROTOTYPE)
public class ProfilePROTOTYPEConfigurationTest extends RestServiceControllerTest{
	
	@Test
	public void testSayHelloActiveProfile() throws Exception{
		ResultActions andExpect = mvc.perform(get("/hello/world/visitor/" + activeProfile.getProfileName())).andExpect(status().is2xxSuccessful());
		String contentAsString = andExpect.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}

}
