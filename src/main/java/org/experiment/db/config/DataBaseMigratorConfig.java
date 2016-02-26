package org.experiment.db.config;

/*
@Configuration
@ConditionalOnClass(Flyway.class)
@ConditionalOnBean(FlywayAutoConfiguration.class)
@AutoConfigureAfter({ Flyway.class})
public class DataBaseMigratorConfig {

    @Autowired
    private Flyway flyway;

    @Bean
    @Profile(EnvironmentUtilsLocal.DEV)
    public void customizeFlyway(){
        flyway.setSchemas(IConnectionsString.SCHEMA_NAME_FLYWAY_INIT, IConnectionsString.SCHEMA_NAME);
    }
}
*/
