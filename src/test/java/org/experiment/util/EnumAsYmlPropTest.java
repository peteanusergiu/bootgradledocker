package org.experiment.util;

import org.experiment.Application;
import org.experiment.base.AbstractRestServiceControllerTest;
import org.experiment.prop.RestProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by sepetean on 10/20/2015.
 */
@ActiveProfiles(EnvironmentUtils.DEV_H2)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class EnumAsYmlPropTest extends AbstractRestServiceControllerTest {

	@Autowired
	private RestProperties restProperties;

    @Test
    public void testMapAYmlProperty2Enum() throws Exception{

        Properties enumValue = restProperties.getEnumValue();
        System.out.println(enumValue);

    }

}
