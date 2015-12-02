package org.experiment.config;

import org.experiment.extensions.processors.LogInjector;
import org.experiment.prop.RestProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableConfigurationProperties(RestProperties.class)
@Import({LogInjector.class})
public class ExtensionConfig {
    //empty class used to mark extensions configuration beans
}
