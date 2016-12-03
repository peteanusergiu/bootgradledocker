package org.experiment.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "cache.redis")
public class RedisCacheProperties {
    @NotNull
    private String host;
    @NotNull
    private Integer port;
    @NotNull
    private Integer seconds2Expiration;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getSeconds2Expiration() {
        return seconds2Expiration;
    }

    public void setSeconds2Expiration(Integer seconds2Expiration) {
        this.seconds2Expiration = seconds2Expiration;
    }
}
