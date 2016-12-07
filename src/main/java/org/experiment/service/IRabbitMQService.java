package org.experiment.service;

import org.experiment.lang.amqp.*;

/**
 * Created by petea on 2/29/2016.
 */
public interface IRabbitMQService {

    SenderResponse publish(Sender sender) throws Exception;

    ReceiverResponse subscribe(Receiver receiver);

    ReceiverResponse subscribe(String queueName);
}
