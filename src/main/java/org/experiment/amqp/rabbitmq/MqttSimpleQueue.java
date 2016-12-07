package org.experiment.amqp.rabbitmq;

import com.rabbitmq.client.*;

import org.springframework.amqp.rabbit.connection.Connection;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.experiment.amqp.rabbitmq.Mqtt.*;

/**
 * Created by petea on 11/25/2016.
 */
public class MqttSimpleQueue {


    public static void send2MQTT(Connection connection, String queue) throws IOException, TimeoutException {
        Channel channel = connection.createChannel(TRANSACTIONAL);

        channel.queueDeclare(queue, DURABLE, EXCLUSIVE, AUTO_DELETE, null);

        channel.basicPublish( "", queue,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                "message".getBytes());
        System.out.println(" [x] Sent '" + "message" + "'");

        channel.close();
        connection.close();
    }




    public static void consumeFromMQTT(Connection connection, String queue) throws IOException, TimeoutException {
        Channel channel = connection.createChannel(TRANSACTIONAL);

        channel.queueDeclare(queue, DURABLE, EXCLUSIVE, AUTO_DELETE, null);
        GetResponse response = channel.basicGet(queue, !EnableAutoAck);
        if (response == null) {
            System.out.println("No message retrieved!");
        } else {
            AMQP.BasicProperties props = response.getProps();
            byte[] body = response.getBody();
            String message = new String(body, "UTF-8");
            long deliveryTag = response.getEnvelope().getDeliveryTag();
            channel.basicAck(deliveryTag, false); // acknowledge receipt of the message
            System.out.println(String.format("Queue #s returned prop.contentType: %s, body: %s and deliveryTag: %s",
                    queue, props.getContentType(), message, deliveryTag));
        }

        channel.close();
        connection.close();

    }
    /*consumer blocks and waits for messages - should be run in it's own class(see MqttRecv.java)
    * It will read only first message - not relevant as test
    * */
    public static void subscribe2MQTT(Connection connection, String queue) throws IOException, TimeoutException {
        Channel channel = connection.createChannel(TRANSACTIONAL);

        channel.queueDeclare(queue, DURABLE, EXCLUSIVE, AUTO_DELETE, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        channel.basicQos(1);

        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(" [x] Received '" + message + "'");
                try {
                    work(message);
                } finally {
                    System.out.println(" [x] Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        channel.basicConsume(queue, !EnableAutoAck, consumer);

        channel.close();
        connection.close();
    }

    private static void work(String message) {
        System.out.println(String.format(" [x] Message %s was Processed !", message));
    }


}
