package org.experiment.config;

import org.experiment.lang.ProfileBean;
import org.experiment.util.EnvironmentUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileDEVH2Configuration {
	
	@Bean
	@Profile(EnvironmentUtils.DEV_H2)
	public ProfileBean activeProfile() {
		return new ProfileBean(EnvironmentUtils.DEV_H2);
	}

}
