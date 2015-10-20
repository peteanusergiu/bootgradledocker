package org.experiment.config;

import org.experiment.lang.ProfileBean;
import org.experiment.util.EnvironmentUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileDEVMYSQLConfiguration {
	
	@Bean
	@Primary
	@Profile(EnvironmentUtils.DEV_MYSQL)
	public ProfileBean activeProfile() {
		return new ProfileBean(EnvironmentUtils.DEV_MYSQL);
	}
}
