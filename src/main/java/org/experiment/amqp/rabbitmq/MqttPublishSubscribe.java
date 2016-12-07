package org.experiment.amqp.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.GetResponse;
import org.experiment.db.repo.IOTRepository;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by petea on 11/25/2016.
 */
public class MqttPublishSubscribe {


    @Autowired
    private IOTRepository iotDB;
    /* Creates a generic  exchange and makes the bindings
    * It assumes the existence of the queue
    * If Queue is not existing messages get lost until queue is created. There is no default creation of queue
    * Very useful when reading needs to be simplified
    * */
    public static void publish2MQTTGeneric(Connection connection, String exchange, String exchangeType, String routingKey, String message,
                                           Map<String,Object> headers, String type) throws IOException, TimeoutException {
        Channel channel = connection.createChannel(Mqtt.TRANSACTIONAL);

        channel.exchangeDeclare(exchange, exchangeType);

        channel.basicPublish( exchange, routingKey,
                buildAMQP(headers, type),
                message.getBytes());

        System.out.println(" [x] Sent '" + "message" + "'");

        channel.close();
        connection.close();
    }
    /* Creates an exchange and a queue and makes the bindings
    * Use it when the client uses the simplified version to subscribe to the queue
    * consumeFromMQTT(String queue)
    * Very useful when reading needs to be simplified
    * */
    public static void publish2MQTT(Connection connection, String exchange, String exchangeType, String routingKey, String message) throws IOException, TimeoutException {
        publish2MQTTGeneric(connection, exchange, exchangeType, routingKey, message, null, "text/plain");
    }

    /* Creates just a GENERIC exchange and set the routing key for the future queues
    (no queue or binding KH. This is the responsibility of the Subscriber)
    * Use it with the more complex Subscriber method
    * consumeFromMQTT(String exchange, String exchangeType, String queue, String routingKey)
    * Very useful when flexibility is important
    * */
    public static void publish2MQTTAndConfigureGeneric(Connection connection, String exchange, String exchangeType, String queue, String routingKey,
                                                       String message, Map<String,Object> headers, String type) throws IOException, TimeoutException {
        Channel channel = connection.createChannel(Mqtt.TRANSACTIONAL);

        channel.exchangeDeclare(exchange, exchangeType);
        channel.queueDeclare(queue, Mqtt.DURABLE, Mqtt.EXCLUSIVE, Mqtt.AUTO_DELETE, null);
        channel.queueBind(queue, exchange, routingKey);

        channel.basicPublish( exchange, routingKey,
                buildAMQP(headers, type),
                message.getBytes());
        System.out.println(" [x] Sent '" + "message" + "'");

        channel.close();
        connection.close();
    }

    /* Creates just an exchange and set the routing key for the future queues
    (no queue or binding KH. This is the responsibility of the Subscriber)
    * Use it with the more complex Subscriber method
    * consumeFromMQTT(String exchange, String exchangeType, String queue, String routingKey)
    * Very useful when flexibility is important
    * */
    public static void publish2MQTTAndConfigure(Connection connection, String exchange, String exchangeType, String queue, String routingKey, String message) throws IOException, TimeoutException {
        publish2MQTTAndConfigureGeneric(connection, exchange, exchangeType, queue, routingKey,
                message, null, "text/plain");
    }

    /*Consumes messages from an existing and configured queue(bind(queue, exchange, key is already performed at creation time))*/
    public static GetResponse consumeFromMQTT(Connection connection, String queue) throws IOException, TimeoutException {
        final Channel channel = connection.createChannel(Mqtt.TRANSACTIONAL);

        channel.queueDeclare(queue, Mqtt.DURABLE, Mqtt.EXCLUSIVE, Mqtt.AUTO_DELETE, null);

        GetResponse response = channel.basicGet(queue, !Mqtt.EnableAutoAck);
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
        return response;
    }

    /*Consumes messages from a queue(bind(queue, exchange, key needs to be performed here))*/
    public static GetResponse consumeFromMQTT(Connection connection, String exchange, String queue, String routingKey) throws IOException, TimeoutException {
        final Channel channel = connection.createChannel(Mqtt.TRANSACTIONAL);

//        channel.exchangeDeclare(exchange, exchangeType);
        channel.queueDeclare(queue, Mqtt.DURABLE, Mqtt.EXCLUSIVE, Mqtt.AUTO_DELETE, null);
        channel.queueBind(queue, exchange, routingKey);

        GetResponse response = channel.basicGet(queue, !Mqtt.EnableAutoAck);
        if (response == null) {
            System.out.println("No message retrieved!");
        } else {
            AMQP.BasicProperties props = response.getProps();
            Map<String, Object> headers = props.getHeaders();
            if (headers!=null && !headers.isEmpty()){
                System.out.println(String.format("Headers found: %s", headers.toString()));
            }
            byte[] body = response.getBody();
            String message = new String(body, "UTF-8");
            long deliveryTag = response.getEnvelope().getDeliveryTag();
            channel.basicAck(deliveryTag, false); // acknowledge receipt of the message
            System.out.println(String.format("Queue #s returned prop.contentType: %s, body: %s and deliveryTag: %s",
                    queue, props.getContentType(), message, deliveryTag));
        }

        channel.close();
        connection.close();
        return response;

    }

    /*creates a new non-persistent queue, associate it with an existing exchange and reads from it
    *
    * !!!it makes sense only when it is included in a while(TRANSACTIONAL) or it subscribes to a queue
    * as it needs time to receive the messages from exchange!!!!!*/
    public static String consumeFromMQTTAnonymousQueue(Connection connection, String exchange, String routingKey) throws IOException, TimeoutException {
        String message = "unknown";
        final Channel channel = connection.createChannel(Mqtt.TRANSACTIONAL);

        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, exchange, routingKey);

        GetResponse response = channel.basicGet(queueName, !Mqtt.EnableAutoAck);
        if (response == null) {
            System.out.println("No message retrieved!");
        } else {
            AMQP.BasicProperties props = response.getProps();
            byte[] body = response.getBody();
            message = new String(body, "UTF-8");
            long deliveryTag = response.getEnvelope().getDeliveryTag();
            channel.basicAck(deliveryTag, false); // acknowledge receipt of the message
            System.out.println(String.format("Queue #s returned prop.contentType: %s, body: %s and deliveryTag: %s",
                    queueName, props.getContentType(), message, deliveryTag));
        }

        channel.close();
        connection.close();

        return message;

    }

    private static AMQP.BasicProperties buildAMQP(Map<String,Object> headers, String type){
        return new AMQP.BasicProperties.Builder().headers(headers).contentType(type).build();
    }


}
