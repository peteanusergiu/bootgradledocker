package org.experiment.config;

import org.experiment.service.IIOTService;
import org.experiment.service.ILoraService;
import org.experiment.service.IRabbitMQService;
import org.experiment.service.impl.IOTServiceImpl;
import org.experiment.service.impl.LoraServiceImpl;
import org.experiment.service.impl.RabbitMQServiceImpl;
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

    @Bean
    public ILoraService loraService() {
        return new LoraServiceImpl();
    }

    @Bean
    public IRabbitMQService rabbitMQService() {
        return new RabbitMQServiceImpl();
    }

}
