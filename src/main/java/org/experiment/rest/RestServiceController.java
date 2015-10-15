package org.experiment.rest;

import org.experiment.lang.ProfileBean;
import org.experiment.lang.RestResponse;
import org.experiment.prop.RestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello/world")
public class RestServiceController {

	@Autowired
	private ProfileBean activeProfile;

	@Autowired
	private RestProperties restProperties;

	
	@RequestMapping(value = "/visitor/{name}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse sayHello(@PathVariable("name") String name) {
		return new RestResponse(restProperties.getMessage(), name);
	}

}
