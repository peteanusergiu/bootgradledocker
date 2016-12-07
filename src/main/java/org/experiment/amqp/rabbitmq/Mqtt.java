package org.experiment.amqp.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by petea on 11/25/2016.
 */
public class Mqtt {
//    private final static String TASK_QUEUE_NAME = "testNew";
//    private final static String HOST_CLOUD_TEST = "reindeer.rmq.cloudamqp.com";
//    private final static String VHOST_TEST = "pteagcgj";
//    private final static String USER_NAME_TEST = "pteagcgj";
//    private final static String PASSWORD_TEST = "CLGKw9x3sgOYSEesl9v8gw6yrHFtR9Xg";

    public final static String AZURE_TEST_QUEUE_NAME = "testQueue";
    public final static String AZURE_TEST_EXCHANGE_NAME = "testExchange";
    public final static String AZURE_TEST_KEY_NAME = "testRoutingKey";

    public final static boolean DURABLE = true;
    public final static boolean EXCLUSIVE = false;
    public final static boolean AUTO_DELETE = false;


    private final static String HOST_CLOUD = "192.168.99.100";
    private final static String VHOST_CLOUD = "s4t-rabbitmq";
    private final static String USER_NAME_CLOUD = "app";
    private final static String PASSWORD_CLOUD = "app";

    /* autoAck = false above, you must also call Channel.basicAck to acknowledge that you have successfully received the message*/
    public final static boolean EnableAutoAck = true;
    public final static boolean TRANSACTIONAL = false;

    public static ConnectionFactory initConnection4MQTTT(String hostCloudTest, String vHost, String userName, String password) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(hostCloudTest);
        factory.setVirtualHost(vHost);
        factory.setUsername(userName);
        factory.setPassword(password);
        return factory;
    }

    public static  org.springframework.amqp.rabbit.connection.ConnectionFactory initCachedConnection4MQTTT(String hostCloudTest, String vHost, String userName, String password) throws IOException, TimeoutException {
        return new CachingConnectionFactory(
                initConnection4MQTTT(hostCloudTest, vHost, userName, password));
    }

    /*public static Connection initConn4MQTT_Cloud() throws IOException, TimeoutException {
        return initConnection4MQTTT(HOST_CLOUD_TEST, VHOST_TEST, USER_NAME_TEST, PASSWORD_TEST);
    }*/

    public static Connection initConn4MQTT_AZURE() throws IOException, TimeoutException {
        return initConnection4MQTTT(HOST_CLOUD, VHOST_CLOUD, USER_NAME_CLOUD, PASSWORD_CLOUD).newConnection();
    }

    public static org.springframework.amqp.rabbit.connection.Connection initCachedConn4MQTT_AZURE() throws IOException, TimeoutException {
        return initCachedConnection4MQTTT(HOST_CLOUD, VHOST_CLOUD, USER_NAME_CLOUD, PASSWORD_CLOUD).createConnection();
    }

    }
