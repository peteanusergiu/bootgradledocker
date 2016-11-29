package org.experiment.util.restclient.conf;

import org.experiment.util.restclient.lang.Pair;

import java.net.URL;


public class LocalRestAssuredConfiguration implements RestAssuredConfiguration {

    private static final String HTTP_LOCALHOST = "http://localhost";
	private int port;
    private String contextPath;
    private String basePath;
    protected String baseURL;

    public LocalRestAssuredConfiguration(int port, String contextPath){
        this(HTTP_LOCALHOST, port, contextPath, null);
    }

    protected LocalRestAssuredConfiguration(String baseURL, int port, String contextPath, String basePath){
        this.baseURL = baseURL;
    	this.port = port;
        this.contextPath = contextPath;
        if(basePath != null){
            this.basePath = basePath;
        }else{
            this.basePath = "/rest";
        }
    }
    
    public LocalRestAssuredConfiguration(int port, String contextPath, String basePath){
        this(HTTP_LOCALHOST, port, contextPath, basePath);
    }

    @Override
    public String getBaseURI() {
        return baseURL;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public String getBasePath() {
        return this.contextPath + this.basePath;
    }

    @Override
    public Pair<URL, String> getKeyStore() {
//    	URL url = LocalRestAssuredConfiguration.class.getResource("cert/truststore.jks");
//      return new Pair<>(url, "changeit");
        return null;
    }

    @Override
    public boolean isProdEnvironment() {
        return false;
    }
}
