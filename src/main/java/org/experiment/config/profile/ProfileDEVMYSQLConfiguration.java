package org.experiment.config.profile;

import org.experiment.lang.json.ProfileBean;
import org.experiment.util.EnvironmentUtilsLocal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileDEVMYSQLConfiguration {
	
	@Bean
	@Primary
	@Profile(EnvironmentUtilsLocal.DEV_MYSQL)
	public ProfileBean activeProfile() {
		return new ProfileBean(EnvironmentUtilsLocal.DEV_MYSQL);
	}
}
