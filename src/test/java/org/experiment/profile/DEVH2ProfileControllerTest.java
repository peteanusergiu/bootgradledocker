package org.experiment.profile;

import org.experiment.Application;
import org.experiment.base.AbstractRestServiceControllerTest;
import org.experiment.util.EnvironmentUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles(EnvironmentUtils.DEV_H2)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class DEVH2ProfileControllerTest extends AbstractRestServiceControllerTest {

//	@Autowired
//	private Flyway flyway;

	@Test
	public void testSayHelloActiveProfile() throws Exception{
		String profileName = activeProfile.getProfileName();
		System.out.println(profileName);
		ResultActions andExpect = mvc.perform(get("/hello/world/visitor/" + profileName)).andExpect(status().is2xxSuccessful());
		String contentAsString = andExpect.andReturn().getResponse().getContentAsString();

/*print migration info - testing the flyway result*/
//		MigrationInfoService info = flyway.info();
//		Arrays.stream(info.all()).forEach(s -> System.out.println(s.getScript()));

		System.out.println(contentAsString);
		
	}
	
}
