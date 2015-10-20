package org.experiment.db.config;

import org.experiment.util.EnvironmentUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/**
 * Project:   Deutsche Telekom - SPICA
 * Author:    Sergiu Petean
 * Copyright: Deutsche Telekom AG
 */

@Configuration
@Profile(EnvironmentUtils.DEV_H2)
public class DatabasePopulatorConfig {
	
	@Bean
	public DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.setSqlScriptEncoding("UTF-8");
		Resource scripts = new ClassPathResource("/sql/db-inserts.sql");
		resourceDatabasePopulator.setScripts(scripts);
		return resourceDatabasePopulator;
	}

	
}
