package org.experiment.db.config;

import com.jolbox.bonecp.BoneCPDataSource;
import org.experiment.prop.JPAProperties;
import org.experiment.prop.bonecp.BoneCPProperties;
import org.experiment.util.EnvironmentUtilsLocal;
import org.experiment.util.IConnectionsString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by sepetean on 10/19/2015.
 */
@Configuration
@Profile(EnvironmentUtilsLocal.DEV_MYSQL)
public class EmbededMySQLDataSourceConfig {

    @Autowired
    private JPAProperties jpaConnectorProperties;

//    @Bean
//    public JPAProperties jpaConnectorProperties(){
//        return new JPAProperties();
//    }



    /*-----------------------------transaction managers---------------------------------------------------------------*/
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder factoryBuilder) {
        return factoryBuilder.dataSource(dataSource()).packages(IConnectionsString.PACKAGES)
                .properties(hibernateJPAProperties()).build();
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder(
            JpaVendorAdapter jpaVendorAdapter) {

        JpaProperties hibernateJPAProperties = new JpaProperties();
        hibernateJPAProperties.setProperties(hibernateJPAProperties());

        EntityManagerFactoryBuilder builder = new EntityManagerFactoryBuilder(
                jpaVendorAdapter, hibernateJPAProperties.getProperties()  , null);
        return builder;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabasePlatform(IConnectionsString.HIBERNATE_DIALECT_MY_SQL);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public Map<String, String> hibernateJPAProperties() {
        JpaProperties jpaProperties = new JpaProperties();
        jpaProperties.setShowSql(true);
//        jpaProperties.setGenerateDdl(true);
        return jpaProperties.getProperties();
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BoneCPProperties boneCPProperties = jpaConnectorProperties.getBonecp();
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(boneCPProperties.getDriverClass());
        dataSource.setJdbcUrl(boneCPProperties.getMaster().getJdbcUrl());
        dataSource.setUsername(boneCPProperties.getMaster().getJdbcUsername());
        dataSource.setPassword(boneCPProperties.getMaster().getJdbcPassword());
        dataSource.setMaxConnectionsPerPartition(boneCPProperties.getMaxConnectionsPerPartition());
        dataSource.setMinConnectionsPerPartition(boneCPProperties.getMinConnectionsPerPartition());
        dataSource.setPartitionCount(boneCPProperties.getPartitionCount());
        dataSource.setAcquireIncrement(boneCPProperties.getAcquireIncrement());
        dataSource.setStatementsCacheSize(boneCPProperties.getStatementsCacheSize());
        dataSource.setAcquireRetryAttempts(boneCPProperties.getAcquireRetryAttempts());
        dataSource.setAcquireRetryDelayInMs(boneCPProperties.getAcquireRetryDelayInMs());
        dataSource.setConnectionTimeoutInMs(boneCPProperties.getConnectionTimeoutInMs());
        //Leave lazyInit enabled!
        //If lazyInit is disabled and the DB is not available on startup, app will hang indefinitely due to a BoneCP bug.
        dataSource.setLazyInit(true);
        return dataSource;
    }


    /*----------------------------------------jdbc templates----------------------------------------------------------*/
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SimpleJdbcInsert simpleJdbcInsert() {
        return new SimpleJdbcInsert(jdbcTemplate()).withSchemaName(IConnectionsString.SCHEMA_NAME_TEST);
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}

