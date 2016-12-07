package org.experiment.mqtt;

import org.apache.commons.collections.map.HashedMap;
import org.experiment.amqp.rabbitmq.Mqtt;
import org.experiment.amqp.rabbitmq.MqttPublishSubscribe;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.rabbit.connection.Connection;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import static org.experiment.amqp.rabbitmq.Mqtt.initCachedConn4MQTT_AZURE;

/**
 * Created by petea on 11/28/2016.
 */
public class MqttPublishSubscribeTest {

    private static final String MESSAGE = "message";
    private static final String MESSAGE_JSON = "{\"message\": \"json\"}";
    private Connection connection;

    @Before
    public void setUp() {
        try {
            connection = initCachedConn4MQTT_AZURE();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    /*Publish a message to AMQP!
    * If Queue is not existing messages get lost until queue is created. There is no default creation of queue*/
    @Test
    public void testPublish2MQTTGeneric_Json() throws Exception {
        MqttPublishSubscribe.publish2MQTTGeneric(connection, Mqtt.AZURE_TEST_EXCHANGE_NAME, "direct", Mqtt.AZURE_TEST_KEY_NAME, MESSAGE_JSON, null, "application/json");
//        assertThat(response.getCode(), Matchers.equalTo(200));
    }

    /*Publish a message to AMQP! It uses the headers to store info!
    * If Queue is not existing messages get lost until queue is created. There is no default creation of queue*/
    @Test
    public void testPublish2MQTTGeneric_HEADERS() throws Exception {
        Map<String, Object> headers = new HashedMap();
        headers.put("latitude",  51.5252949);
        headers.put("longitude", -0.0905493);
        MqttPublishSubscribe.publish2MQTTGeneric(connection, Mqtt.AZURE_TEST_EXCHANGE_NAME, "direct", Mqtt.AZURE_TEST_KEY_NAME, MESSAGE_JSON, headers, "application/json");
//        assertThat(response.getCode(), Matchers.equalTo(200));
    }

    /*Publish a message to AMQP!
    * If Queue is not existing messages get lost until queue is created. There is no default creation of queue*/
    @Test
    public void testPublish2MQTT() throws Exception {
        MqttPublishSubscribe.publish2MQTT(connection, Mqtt.AZURE_TEST_EXCHANGE_NAME, "direct", Mqtt.AZURE_TEST_KEY_NAME, MESSAGE);
//        assertThat(response.getCode(), Matchers.equalTo(200));
    }

    /*Publish a message to AMQP!
    * If Queue is not existing it gets created*/
    @Test
    public void consumeFromMQTT_ConfigureQueue() throws Exception {
        MqttPublishSubscribe.consumeFromMQTT(connection, Mqtt.AZURE_TEST_EXCHANGE_NAME, Mqtt.AZURE_TEST_QUEUE_NAME, Mqtt.AZURE_TEST_KEY_NAME);
//        assertThat(response.getCode(), Matchers.equalTo(200));
    }

    /*Publish a message to AMQP!
    * If Queue is not existing it gets created*/
    @Test
    public void testPublish2MQTTAndConfigure_HEADERS() throws Exception {
        Map<String, Object> headers = new HashedMap();
        headers.put("latitude",  51.5252949);
        headers.put("longitude", -0.0905493);
        MqttPublishSubscribe.publish2MQTTAndConfigureGeneric(connection, Mqtt.AZURE_TEST_EXCHANGE_NAME, "direct", Mqtt.AZURE_TEST_QUEUE_NAME,
                Mqtt.AZURE_TEST_KEY_NAME, MESSAGE, headers, "plain/text");
//        assertThat(response.getCode(), Matchers.equalTo(200));
    }

    /*Publish a message to AMQP!
    * If Queue is not existing it gets created*/
    @Test
    public void testPublish2MQTTAndConfigure() throws Exception {
        MqttPublishSubscribe.publish2MQTTAndConfigure(connection, Mqtt.AZURE_TEST_EXCHANGE_NAME, "direct", Mqtt.AZURE_TEST_QUEUE_NAME, Mqtt.AZURE_TEST_KEY_NAME, MESSAGE);
//        assertThat(response.getCode(), Matchers.equalTo(200));
    }

    @Test
    public void consumeFromMQTT() throws Exception {
        MqttPublishSubscribe.consumeFromMQTT(connection, Mqtt.AZURE_TEST_QUEUE_NAME);
//        assertThat(response.getCode(), Matchers.equalTo(200));
    }

    /*!!it will always returned "no messages" as it needs to be paused , message sent and then read correctly!!*/
    @Test
    public void consumeFromMQTTAnonymousQueue() throws Exception {
        MqttPublishSubscribe.consumeFromMQTTAnonymousQueue(connection, Mqtt.AZURE_TEST_EXCHANGE_NAME, Mqtt.AZURE_TEST_KEY_NAME);
//        assertThat(response.getCode(), Matchers.equalTo(200));
    }
}
