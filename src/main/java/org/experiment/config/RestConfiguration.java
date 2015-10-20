package org.experiment.config;

import org.experiment.prop.RestProperties;
import org.experiment.rest.RestServiceController;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableConfigurationProperties(RestProperties.class)
//@EnableConfigurationProperties
@Import({ProfileDEVH2Configuration.class, ProfileDEVMYSQLConfiguration.class, ProfilePROTOTYPEConfiguration.class})
public class RestConfiguration {

	@Bean
	public RestServiceController restServiceController() {
		return new RestServiceController();
	}
}
