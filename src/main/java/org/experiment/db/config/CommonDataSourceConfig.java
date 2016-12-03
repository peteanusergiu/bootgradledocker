package org.experiment.db.config;

import org.experiment.prop.JPAProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Created by petea on 12/2/2016.
 */
@Configuration
public class CommonDataSourceConfig {

    @Autowired
    protected JPAProperties jpaConnectorProperties;

    /*@Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }*/

}
