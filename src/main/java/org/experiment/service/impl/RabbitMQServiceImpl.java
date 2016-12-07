package org.experiment.service.impl;

import com.rabbitmq.client.GetResponse;
import org.experiment.amqp.rabbitmq.MqttPublishSubscribe;
import org.experiment.extensions.annotation.Log;
import org.experiment.lang.amqp.*;
import org.experiment.service.IRabbitMQService;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by petea on 2/29/2016.
 */
public class RabbitMQServiceImpl implements IRabbitMQService {

    @Log
    Logger log;

    @Autowired
    private Connection amqpConnection;

    @Override
    public SenderResponse publish(Sender sender) {
        String reason;
        try {
            MqttPublishSubscribe.publish2MQTTAndConfigureGeneric(amqpConnection, sender.getExchange(),
                    sender.getExchangeType(), sender.getQueue(), sender.getBindingKey(), "headers are used for value",
                    buildHeaders(sender), "application/json");
            return new SenderResponse("200", "Message successfully processed", String.format("Message added to RabbitMQ queue %s", sender.getQueue()));
        } catch (IOException e) {
            e.printStackTrace();
            reason = e.getMessage();
        } catch (TimeoutException e) {
            e.printStackTrace();
            reason = e.getMessage();
        }
        return new SenderResponse("401", "Message failed to be added to RabbitMQ", String.format("Message failed to be added to RabbitMQ. Reason %s",reason ));
    }

    @Override
    public ReceiverResponse subscribe(Receiver receiver) {
        String reason = "Queue is empty!";
        try {
            Location senderMessage = new Location();
            GetResponse getResponse = MqttPublishSubscribe.consumeFromMQTT(amqpConnection, receiver.getQueue());
            if (getResponse!=null) {
                Map<String, Object> headers = getResponse.getProps().getHeaders();
                if (headers != null && !headers.isEmpty()) {
                    Double latitude =  Double.valueOf(headers.getOrDefault("latitude", "0").toString());
                    Double longitude = Double.valueOf(headers.getOrDefault("longitude", "0").toString());
                    senderMessage = new Location(latitude,longitude);
                }

                return new ReceiverResponse(senderMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
            reason = e.getMessage();
        } catch (TimeoutException e) {
            e.printStackTrace();
            reason = e.getMessage();
        }
        return new ReceiverResponse("402", "Message failed to be retrieved from RabbitMQ", String.format("Message failed to be added to RabbitMQ. Reason %s",reason));
    }

    @Override
    public ReceiverResponse subscribe(String queueName) {
        String reason = "Queue is empty!";
        try {
            Location senderMessage = new Location();
            GetResponse getResponse = MqttPublishSubscribe.consumeFromMQTT(amqpConnection, queueName);
            if (getResponse != null) {
                Map<String, Object> headers = getResponse.getProps().getHeaders();
                if (headers != null && !headers.isEmpty()) {
                    Double latitude =  Double.valueOf(headers.getOrDefault("latitude", "0").toString());
                    Double longitude = Double.valueOf(headers.getOrDefault("longitude", "0").toString());
                    senderMessage = new Location(latitude,longitude);
                }

                return new ReceiverResponse(senderMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
            reason = e.getMessage();
        } catch (TimeoutException e) {
            e.printStackTrace();
            reason = e.getMessage();
        }
        return new ReceiverResponse("402", "Message failed to be retrieved from RabbitMQ", String.format("Message failed to be added to RabbitMQ. Reason %s",reason));
    }

    private Map<String, Object> buildHeaders(Sender sender) {
        Map<String,Object> headers = new HashMap<>();
        headers.put("latitude", sender.getMessage().getLatitude());
        headers.put("longitude", sender.getMessage().getLongitude());
        return headers;
    }
//    @Autowired
//    private IOTRepository iotDB;



}
