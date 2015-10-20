package org.experiment.db.jpa;

import org.experiment.db.config.EmbededH2DataSourceConfig;
import org.experiment.db.config.ReleaseDataSourceConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@EnableConfigurationProperties
@Import({EmbededH2DataSourceConfig.class, ReleaseDataSourceConfig.class})
public class JPAServiceController {
}
