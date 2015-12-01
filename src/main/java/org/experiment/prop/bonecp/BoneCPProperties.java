package org.experiment.prop.bonecp;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "jpa.boneCP")
public class BoneCPProperties {
    @NotNull
    private String driverClass = "com.mysql.jdbc.Driver";
    @NotNull
    private Integer maxConnectionsPerPartition = 2;
    @NotNull
    private Integer minConnectionsPerPartition = 1;
    @NotNull
    private Integer partitionCount = 3;
    @NotNull
    private Integer acquireIncrement = 10;
    @NotNull
    private Integer statementsCacheSize = 50;
    @NotNull
    private Integer releaseHelperThreads = 3;
    @NotNull
    private Integer acquireRetryAttempts = 0;
    @NotNull
    private Integer acquireRetryDelayInMs = 1000;
    @NotNull
    private Integer connectionTimeoutInMs = 3000;
    @NotNull
    private BoneCPPropertiesMaster master = new BoneCPPropertiesMaster();

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public Integer getMaxConnectionsPerPartition() {
        return maxConnectionsPerPartition;
    }

    public void setMaxConnectionsPerPartition(Integer maxConnectionsPerPartition) {
        this.maxConnectionsPerPartition = maxConnectionsPerPartition;
    }

    public Integer getMinConnectionsPerPartition() {
        return minConnectionsPerPartition;
    }

    public void setMinConnectionsPerPartition(Integer minConnectionsPerPartition) {
        this.minConnectionsPerPartition = minConnectionsPerPartition;
    }

    public Integer getPartitionCount() {
        return partitionCount;
    }

    public void setPartitionCount(Integer partitionCount) {
        this.partitionCount = partitionCount;
    }

    public Integer getAcquireIncrement() {
        return acquireIncrement;
    }

    public void setAcquireIncrement(Integer acquireIncrement) {
        this.acquireIncrement = acquireIncrement;
    }

    public Integer getStatementsCacheSize() {
        return statementsCacheSize;
    }

    public void setStatementsCacheSize(Integer statementsCacheSize) {
        this.statementsCacheSize = statementsCacheSize;
    }

    public Integer getReleaseHelperThreads() {
        return releaseHelperThreads;
    }

    public void setReleaseHelperThreads(Integer releaseHelperThreads) {
        this.releaseHelperThreads = releaseHelperThreads;
    }

    public Integer getAcquireRetryAttempts() {
        return acquireRetryAttempts;
    }

    public void setAcquireRetryAttempts(Integer acquireRetryAttempts) {
        this.acquireRetryAttempts = acquireRetryAttempts;
    }

    public Integer getAcquireRetryDelayInMs() {
        return acquireRetryDelayInMs;
    }

    public void setAcquireRetryDelayInMs(Integer acquireRetryDelayInMs) {
        this.acquireRetryDelayInMs = acquireRetryDelayInMs;
    }

    public Integer getConnectionTimeoutInMs() {
        return connectionTimeoutInMs;
    }

    public void setConnectionTimeoutInMs(Integer connectionTimeoutInMs) {
        this.connectionTimeoutInMs = connectionTimeoutInMs;
    }

    public BoneCPPropertiesMaster getMaster() {
        return master;
    }

    public void setMaster(BoneCPPropertiesMaster master) {
        this.master = master;
    }

}
