package org.experiment.prop.bonecp;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix="jpa.boneCP.master")
public class BoneCPPropertiesMaster {
    @NotNull
    private String jdbcUrl;
    @NotNull
    private String jdbcUsername;
    @NotNull
    private String jdbcPassword;

    public String getJdbcUrl() {
        return jdbcUrl;
    }
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }
    public String getJdbcUsername() {
        return jdbcUsername;
    }
    public void setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
    }
    public String getJdbcPassword() {
        return jdbcPassword;
    }
    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }
}
