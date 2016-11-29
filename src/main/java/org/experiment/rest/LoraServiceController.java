package org.experiment.rest;

import org.experiment.extensions.annotation.Log;
import org.experiment.lang.lora.Lora;
import org.experiment.lang.lora.LoraResponse;
import org.experiment.prop.RestProperties;
import org.experiment.service.ILoraService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
public class LoraServiceController extends BaseController{

    @Log
    Logger log;

    @Autowired
    private ILoraService loraService;

    @Autowired
    private RestProperties restProperties;

    @RequestMapping(value = "/lora",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public LoraResponse retrievePackets(@Valid @RequestBody Lora lora) {
        System.out.println("Received a lora request for retrieving packages!");

        /*return tryWithRecovery(() ->
                iotService.createUpdateIOT(iot),
                IOTResponse.class);*/
        return loraService.retrievePackets(lora);
//        LoraResponse loraResponse = loraService.retrievePackets(lora);
//        return loraResponse.getPackets();
    }

}
