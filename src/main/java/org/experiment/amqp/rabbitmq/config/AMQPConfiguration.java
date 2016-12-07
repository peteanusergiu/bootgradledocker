package org.experiment.amqp.rabbitmq.config;

import com.rabbitmq.client.ConnectionFactory;
import org.experiment.prop.AMQPProperties;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author:    Sergiu Petean
 */

@Configuration
public class AMQPConfiguration {


    @Autowired
    protected AMQPProperties amqpProperties;

    @Bean
    public ConnectionFactory amqpConnectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(amqpProperties.getHost());
        factory.setVirtualHost(amqpProperties.getVhost());
        factory.setUsername(amqpProperties.getUsername());
        factory.setPassword(amqpProperties.getPassword());
        return factory;
    }

    @Bean
    public CachingConnectionFactory amqpCachedConnectionFactory(ConnectionFactory amqpConnectionFactory) {
        return new CachingConnectionFactory(amqpConnectionFactory);
    }

    @Bean
    public org.springframework.amqp.rabbit.connection.Connection amqpConnection(CachingConnectionFactory amqpCachedConnectionFactory) {
        return amqpCachedConnectionFactory.createConnection();
    }

}
