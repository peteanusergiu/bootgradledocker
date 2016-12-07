package org.experiment.config;

import org.experiment.amqp.rabbitmq.config.AMQPConfiguration;
import org.experiment.prop.AMQPProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableConfigurationProperties(AMQPProperties.class)
@Import(AMQPConfiguration.class)
public class AMQPConfig {

}