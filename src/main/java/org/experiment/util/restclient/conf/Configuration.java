package org.experiment.util.restclient.conf;

import org.joda.time.DateTimeZone;
import org.springframework.http.MediaType;

public class Configuration {

    private final boolean isProdEnvironment;
    private final String mediaTypeProduced;
    private final String mediaTypeConsumed;
    private final DateTimeZone timeZone;
    private final String accessToken;

    public Configuration(boolean isProdEnvironment) {
        this(isProdEnvironment, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE, null);
    }

    public Configuration(boolean isProdEnvironment, String mediaTypeProduced, String mediaTypeConsumed, String accessToken) {
        this(isProdEnvironment, mediaTypeProduced, mediaTypeConsumed, null, accessToken);
    }

    private Configuration(boolean isProdEnvironment, 
                          String mediaTypeProduced, String mediaTypeConsumed, DateTimeZone timeZone, String accessToken) {
        this.isProdEnvironment = isProdEnvironment;
        this.mediaTypeProduced = mediaTypeProduced;
        this.mediaTypeConsumed = mediaTypeConsumed;
        this.timeZone = timeZone;
        this.accessToken = accessToken;
    }

    public Configuration withTimezone(DateTimeZone timeZone) {
        return new Configuration(this.isProdEnvironment, this.mediaTypeProduced,this.mediaTypeConsumed, timeZone, null);
    }

    public Configuration withMediaType(String mediaTypeProduced, String mediaTypeConsumed) {
        return new Configuration(this.isProdEnvironment, mediaTypeProduced, mediaTypeConsumed, this.timeZone, null);
    }

    public Configuration withMediaTypeAndAccessToken(String mediaTypeProduced, String mediaTypeConsumed, String accessToken) {
    	return new Configuration(this.isProdEnvironment, mediaTypeProduced, mediaTypeConsumed, this.timeZone, accessToken);
    }

    @Override
    public String toString() {
        return "Configuration: [" + this.mediaTypeProduced + ", " + this.mediaTypeConsumed + "]";
    }

    public String getMediaTypeProduced() {
        return this.mediaTypeProduced;
    }

    public DateTimeZone getTimeZone() {
        return this.timeZone;
    }

	public String getMediaTypeConsumed() {
		return mediaTypeConsumed;
	}

	public String getAccessToken() {
		return accessToken;
	}

   
}
