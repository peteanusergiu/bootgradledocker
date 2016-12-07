package org.experiment.config;

import org.experiment.config.profile.ProfileDEVH2Configuration;
import org.experiment.config.profile.ProfileDEVMYSQLConfiguration;
import org.experiment.config.profile.ProfilePROTOTYPEConfiguration;
import org.experiment.prop.RestProperties;
import org.experiment.rest.*;
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
	public IOTServiceController iotRestServiceController() {
		return new IOTServiceController();
	}

	@Bean
	public LoraServiceController loraRestServiceController() {
		return new LoraServiceController();
	}

	@Bean
	public DBRestServiceController dbRestServiceController() {
		return new DBRestServiceController();
	}

	@Bean
	public JPARestServiceController jpaRestServiceController() {
		return new JPARestServiceController();
	}

	@Bean
	public RabbitMQServiceController rabbitMQServiceController() {
		return new RabbitMQServiceController();
	}
}
