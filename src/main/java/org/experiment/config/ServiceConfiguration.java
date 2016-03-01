package org.experiment.config;

import org.experiment.service.IIOTService;
import org.experiment.service.impl.IOTServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@EnableConfigurationProperties(ServiceProperties.class)
@Import({JPAConfiguration.class})
public class ServiceConfiguration {

    @Bean
    public IIOTService iotService() {
        return new IOTServiceImpl();
    }

}
