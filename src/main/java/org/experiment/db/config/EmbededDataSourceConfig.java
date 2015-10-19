package org.experiment.db.config;

import org.experiment.util.EnvironmentUtils;
import org.experiment.util.IConnectionsString;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sepetean on 9/30/2015.
 */
@Configuration
//@Import({DataBaseMigratorConfig.class})
public class EmbededDataSourceConfig {

//    @Profile(EnvironmentUtils.DEV)
//    @Bean(destroyMethod = "shutdown", initMethod = "start")
//	@DependsOn(value="h2WebServer")
//	public Server h2Server() throws Exception {
//		return Server.createTcpServer("-tcpAllowOthers","-tcpPort","9097");
//	}
//
//	@Profile(EnvironmentUtils.DEV)
//	@Bean(destroyMethod = "shutdown", initMethod = "start")
//	public Server h2WebServer() throws Exception {
//		return Server.createWebServer("-webAllowOthers", "-webPort", "8087");
//	}

    @Profile(EnvironmentUtils.DEV)
    @Bean(destroyMethod = "shutdown")
//	@DependsOn(value="h2Server")
    public EmbeddedDatabase dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
//        	.setName(IConnectionsString.SCHEMA_NAME)
//                .addScripts("/sql/db-structure.sql")
                        .build();
    }

    @Bean
    @Profile(EnvironmentUtils.DEV)
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabasePlatform(IConnectionsString.HIBERNATE_DIALECT_H2);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    @Profile(EnvironmentUtils.DEV)
    public Map<String, String> hibernateJPAProperties() {
        JpaProperties jpaProperties = new JpaProperties();
        jpaProperties.setShowSql(true);
        jpaProperties.setDatabase(Database.H2);

        Map<String,String> properties = new HashMap<>();
//	      properties.setProperty("hibernate.connection.zeroDateTimeBehavior", "convertToNull");
		 /*essential for passing all the tests. Meta-data awareness of some data require the schema name*/
        properties.put("hibernate.default_schema", IConnectionsString.SCHEMA_NAME);

        jpaProperties.setProperties(properties);
        return jpaProperties.getProperties();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Profile(EnvironmentUtils.DEV)
    public SimpleJdbcInsert simpleJdbcInsert() {
        return new SimpleJdbcInsert(jdbcTemplate()).withSchemaName(IConnectionsString.SCHEMA_NAME);
    }

    @Bean
    @Profile(EnvironmentUtils.DEV)
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
