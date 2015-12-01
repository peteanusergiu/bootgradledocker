package org.experiment.prop.bonecp;

import javax.validation.constraints.NotNull;

public class BoneCPPropertiesENVConnection {
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