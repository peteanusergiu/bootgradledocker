package org.experiment.mqtt;

import org.experiment.amqp.rabbitmq.MqttSimpleQueue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.rabbit.connection.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.experiment.amqp.rabbitmq.Mqtt.initCachedConn4MQTT_AZURE;

/**
 * Created by petea on 11/25/2016.
 */
public class MqttSimpleQueueTest {

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

    @Test
    public void testSend2MQTT() throws Exception {
        MqttSimpleQueue.send2MQTT(connection, "test");
//        assertThat(response.getCode(), Matchers.equalTo(200));
    }

    @Test
    public void consumeFromMQTT() throws Exception {
        MqttSimpleQueue.consumeFromMQTT(connection, "test");
//        assertThat(response.getCode(), Matchers.equalTo(200));
    }
    @Test
    public void testSubscribe2MQTT() throws Exception {
        MqttSimpleQueue.subscribe2MQTT(connection, "test3");
//        assertThat(response.getCode(), Matchers.equalTo(200));
    }

}