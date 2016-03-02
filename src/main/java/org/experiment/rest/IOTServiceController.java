package org.experiment.rest;

import org.experiment.extensions.annotation.Log;
import org.experiment.lang.generic.IOTResponse;
import org.experiment.lang.iot.IOT;
import org.experiment.lang.xml.RestResponse;
import org.experiment.prop.RestProperties;
import org.experiment.service.IIOTService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class IOTServiceController extends BaseController{

    @Log
    Logger log;

    @Autowired
    private IIOTService iotService;

    @Autowired
    private RestProperties restProperties;

    @RequestMapping(value = "/soap/iot",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public IOTResponse recordIOT(@Valid @RequestBody IOT iot) {
        System.out.println("Received an iot request!");

        /*return tryWithRecovery(() ->
                iotService.createUpdateIOT(iot),
                IOTResponse.class);*/
        return iotService.createUpdateIOT(iot);
    }

    @RequestMapping(value = "/isAlive/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse select(@PathVariable("name") String name) {
        System.out.println("Service is alive!!");
        return new RestResponse("I'm alive and kicking!!", name);
    }
}
