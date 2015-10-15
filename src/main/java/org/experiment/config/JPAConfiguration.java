package org.experiment.config;

import org.experiment.db.config.EmbededDataSourceConfig;
import org.experiment.db.config.ReleaseDataSourceConfig;
import org.experiment.prop.BoneCPProperties;
import org.experiment.prop.JPAProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by sepetean on 9/29/2015.
 */
@Configuration
@EnableConfigurationProperties({JPAProperties.class, BoneCPProperties.class})
@Import({EmbededDataSourceConfig.class, ReleaseDataSourceConfig.class})
public class JPAConfiguration {

//    @Bean
//    public JPAServiceController jpaServiceController() {
//        return new JPAServiceController();
//    }
}
