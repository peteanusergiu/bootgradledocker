package org.experiment.profile;

import org.experiment.RestServiceControllerTest;
import org.experiment.lang.ProfileBean;
import org.experiment.util.EnvironmentUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Profile(EnvironmentUtils.DEV)
public class DEVProfileControllerTest extends RestServiceControllerTest{

	@Autowired
	private ProfileBean activeProfile;

//	@Autowired
//	private Flyway flyway;

	
	@Test
	public void testSayHelloActiveProfile() throws Exception{
		ResultActions andExpect = mvc.perform(get("/hello/world/visitor/" + activeProfile.getProfileName())).andExpect(status().is2xxSuccessful());
		String contentAsString = andExpect.andReturn().getResponse().getContentAsString();
/*print migration info - testing the flyway result*/
//		MigrationInfoService info = flyway.info();
//		Arrays.stream(info.all()).forEach(s -> System.out.println(s.getScript()));

		System.out.println(contentAsString);
		
	}
	
}
