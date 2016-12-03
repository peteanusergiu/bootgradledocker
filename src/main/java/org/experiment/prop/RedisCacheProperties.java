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
    @NotNull
    private Integer maxIdle;
    @NotNull
    private Integer maxTotal;
    @NotNull
    private Integer maxWait;

    public RedisCacheProperties() {
    }

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

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }
}
