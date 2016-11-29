package org.experiment.util;

/**
 * Created by sepetean on 9/30/2015.
 */
public interface IConnectionsString {

    String HIBERNATE_DIALECT_H2 = "org.hibernate.dialect.H2Dialect";
    String HIBERNATE_DIALECT_MY_SQL = "org.hibernate.dialect.MySQLDialect";

    String SCHEMA_NAME_FLYWAY_INIT = "public";
    String SCHEMA_NAME_TEST = "physicalwebtest";
    String SCHEMA_NAME_INTEG_TEST = "test";

    String PACKAGES = "org.experiment.db.entities";
}
