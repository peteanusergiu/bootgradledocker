package org.experiment.config.profile;

import org.experiment.lang.json.ProfileBean;
import org.experiment.util.EnvironmentUtilsLocal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileDEVH2Configuration {
	
	@Bean
	@Profile(EnvironmentUtilsLocal.DEV_H2)
	public ProfileBean activeProfile() {
		return new ProfileBean(EnvironmentUtilsLocal.DEV_H2);
	}

}
