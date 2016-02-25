package org.experiment.rest;

import net.atos.esb.services.esbeventservice.CreateEvent;
import org.experiment.db.repo.CustomerRepository;
import org.experiment.extensions.annotation.Log;
import org.experiment.lang.xml.IOT;
import org.experiment.lang.xml.RestResponse;
import org.experiment.lang.xml.ReturnType1;
import org.experiment.prop.RestProperties;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldRestServiceController {

	@Log
	Logger log;

	@Autowired
	private RestProperties restProperties;

	@Autowired
	private CustomerRepository customerDB;

    /*demo example on how to create a RESTfull service serving a HTPP GET method*/
	@RequestMapping(value = "/world/visitor/{name}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse sayHello(@PathVariable("name") String name) {
//		return new RestResponse(restProperties.getMessage(), name);
		System.out.println(restProperties.getMessage());
		return new RestResponse(String.format("You've sent %s. I'm returning %s", name, customerDB.findOne(1L)), name);
	}

//    /*demo example on how to create a RESTfull service serving a HTPP PUT method
//    * it simulates a SOAP service through Rest sevice*/
//	@RequestMapping(value = "/soap/",
//			method = RequestMethod.POST,
//			consumes = MediaType.APPLICATION_XML_VALUE,
//			produces = MediaType.APPLICATION_XML_VALUE)
//	public RestResponse sayHello2SOAP(@RequestBody CreateEvent createEvent) {
//		if (createEvent!=null && createEvent.getEvent()!=null && createEvent.getEvent().getEventKey()!=null) {
//			log.info(createEvent.getEvent().getEventKey().getEventID());
//			return new RestResponse(String.format("You've sent a SOAP event with event key ID: %s. I'm returning %s",
//					createEvent.getEvent().getEventKey().getEventID(), "hello SOAP"), "SOAP");
//		}
//		return new RestResponse(String.format("You've sent a SOAP event with configuration ID: %s. I'm returning %s",
//				"UNKNOWN", "hello SOAP"), "SOAP");
//	}

	@RequestMapping(value = "/soap/create",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_XML_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE)
	public ReturnType1 sayHello2SOAP(@RequestBody CreateEvent createEvent) {
        ReturnType1 result = new ReturnType1();
		result.setDescription("Here's the ReturnType result!");
		if (createEvent!=null && createEvent.getEvent()!=null && createEvent.getEvent().getEventKey()!=null) {
			log.info(createEvent.getEvent().getEventKey().getEventID());
			result.setDetail(String.format("You've sent a SOAP event with event key ID: %s. I'm returning %s",
					createEvent.getEvent().getEventKey().getEventID(), "hello SOAP"));
			result.setReturnCode("200");
			return result;
		}
		result.setDetail(String.format("You've sent a SOAP event with configuration ID: %s. I'm returning %s",
				"UNKNOWN", "hello SOAP"));
		result.setReturnCode("400");
		return result;
	}

	@RequestMapping(value = "/soap/",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_XML_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE)
	public ReturnType1 sayHello2SOAP(@RequestBody IOT iot) {
        ReturnType1 result = new ReturnType1();
		result.setDescription("Here's the ReturnType result!");
		if (iot!=null && iot.getBeacon() != null && (!iot.getBeacon().getTlms().isEmpty() ||  !iot.getBeacon().getUids().isEmpty() || !iot.getBeacon().getUrls().isEmpty())) {
			log.info("Processing IOT with MAC : " + iot.getMac());
			result.setDetail(String.format("You've sent a SOAP IOT with MAC : %s. I'm returning %s",
					iot.getMac(), "hello SOAP"));
			result.setReturnCode("200");
			return result;
		}
		result.setDetail(String.format("You've sent a SOAP event with configuration ID: %s. I'm returning %s",
				"UNKNOWN", "hello SOAP"));
		result.setReturnCode("400");
		return result;
	}
}
