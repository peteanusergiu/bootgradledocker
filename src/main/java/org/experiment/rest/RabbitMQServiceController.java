package org.experiment.rest;

import org.experiment.extensions.annotation.Log;
import org.experiment.lang.amqp.*;
import org.experiment.prop.RestProperties;
import org.experiment.service.IRabbitMQService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class RabbitMQServiceController extends BaseController {

    @Log
    Logger log;

    @Autowired
    private IRabbitMQService rabbitMQService;

    @Autowired
    private RestProperties restProperties;

    @RequestMapping(value = "/mqtt/publish",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SenderResponse recordIOT(@Valid @RequestBody Sender sender) throws Exception {
        System.out.println(String.format("RabbitMQ publish request received for queue: %s", sender.getQueue()));

        /*return tryWithRecovery(() ->
                iotService.publish(iot),
                IOTResponse.class);*/
        return rabbitMQService.publish(sender);
    }

    @RequestMapping(value = "/mqtt/publishTo/{queueName}",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SenderResponse recordIOT(@Valid @RequestBody Sender sender, @PathVariable("queueName") String queueName) throws Exception {
       /*overrides the queue name */
        if (queueName!=null && !queueName.isEmpty()) {
            sender.setQueue(queueName);
        }
        System.out.println(String.format("RabbitMQ publish request received for queue: %s", sender.getQueue()));

        /*return tryWithRecovery(() ->
                iotService.publish(iot),
                IOTResponse.class);*/
        return rabbitMQService.publish(sender);
    }


    @RequestMapping(value = "/mqtt/subscribe",
            method = RequestMethod.POST,
            consumes = {MediaType.ALL_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Location subscribe(@Valid @RequestBody Receiver receiver) {
        System.out.println(String.format("RabbitMQ subscribe request received for queue: %s", receiver.getQueue()));

        ReceiverResponse subscribe = rabbitMQService.subscribe(receiver);
        if (subscribe.getCode().contains("200")) {
            return subscribe.getMessage();
        } else {
            return new Location();
        }

    }
    @RequestMapping(value = "/mqtt/subscribeTo/{queueName}",
            method = RequestMethod.GET,
            consumes = {MediaType.ALL_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Location subscribe(@PathVariable("queueName") String queueName) {
        System.out.println(String.format("RabbitMQ subscribe request received for queue: %s", queueName));

        ReceiverResponse subscribe = rabbitMQService.subscribe(queueName);
        if (subscribe.getCode().contains("200")) {
            return subscribe.getMessage();
        } else {
            return new Location();
        }

    }

}
