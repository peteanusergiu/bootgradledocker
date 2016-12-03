package org.experiment.config;

import org.experiment.cache.config.RedisConfiguration;
import org.experiment.prop.RedisCacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableCaching
@EnableConfigurationProperties(RedisCacheProperties.class)
@Import(RedisConfiguration.class)
public class CacheConfig{

}