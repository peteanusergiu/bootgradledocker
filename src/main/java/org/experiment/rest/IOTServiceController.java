package org.experiment.rest;

import org.experiment.db.entities.iot.IOTEntity;
import org.experiment.db.repo.IOTRepository;
import org.experiment.extensions.annotation.Log;
import org.experiment.lang.generic.IOTResponse;
import org.experiment.lang.iot.IOT;
import org.experiment.prop.RestProperties;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Calendar;

@RestController
@RequestMapping(value = "/hello")
public class IOTServiceController extends BaseController{

    @Log
    Logger log;

    @Autowired
    private RestProperties restProperties;

    @Autowired
    private IOTRepository iotDB;


    @RequestMapping(value = "/soap/iot",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<IOTResponse> recordIOT(@Valid @RequestBody IOT iot) {
        System.out.println("Processing a iot request!");
        IOTEntity demo = new IOTEntity();
        demo.setMac("mac"+ Calendar.getInstance().getTimeInMillis());
        demo.setType("type"+ Calendar.getInstance().getTimeInMillis());
        iotDB.save(demo);
        return tryWithRecovery(() ->
                new IOTResponse("IOT-0000", iot.getMac(), "IOT creation result", "A detailed description of a IOT creation operation!"),
                IOTResponse.class);
    }
}
