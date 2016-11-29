package org.experiment.util.restclient.conf;

public class RemoteRestAssuredConfiguration extends LocalRestAssuredConfiguration{

	public RemoteRestAssuredConfiguration(String baseURL, int port, String contextPath, String basePath){
			super(baseURL, port, contextPath,basePath);
	}
}

