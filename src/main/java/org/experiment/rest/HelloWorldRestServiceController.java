package org.experiment.rest;

import org.experiment.db.repo.CustomerRepository;
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
public class HelloWorldRestServiceController {

	@Autowired
	private RestProperties restProperties;

	@Autowired
	private CustomerRepository customerDB;


	@RequestMapping(value = "/visitor/{name}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse sayHello(@PathVariable("name") String name) {
//		return new RestResponse(restProperties.getMessage(), name);
		System.out.println(restProperties.getMessage());
		return new RestResponse(String.format("You've sent %s. I'm returning %s", name, customerDB.findOne(1L)), name);
	}

}
