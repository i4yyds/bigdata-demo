package com.bigdata.test;

import com.bigdata.common.bean.MetricPort;
import com.bigdata.common.bean.Port;
import com.bigdata.common.util.TimeUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import com.alibaba.fastjson.JSON;

import java.util.*;

public class KafkaPortMetricProducer {

    public static void main(String[] args) {
        // Kafka producer configuration settings
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create a Kafka producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        try {
            while (true) {

                // Create a Metric object
                MetricPort metric = new MetricPort();
                metric.setId(UUID.randomUUID().toString());
                metric.setCloudId(0);
                metric.setIp("192.168.1.1");
                metric.setTms(TimeUtil.getCurrentTms());
                metric.setTime(TimeUtil.getCurrentTime());

                List<Port> list = new ArrayList<>();
                list.add(new Port(1, 3306));
                list.add(new Port(1, 80));
                list.add(new Port(1, 2181));
                metric.setValue(list);

                // Convert Metric object to JSON string using fastjson
                String jsonString = JSON.toJSONString(metric);

                // Create a producer record
                ProducerRecord<String, String> record = new ProducerRecord<>("port_metric", jsonString);

                // Send data - asynchronous
                producer.send(record, (RecordMetadata metadata, Exception exception) -> {
                    if (exception != null) {
                        exception.printStackTrace();
                    } else {
                        System.out.printf("Sent record(key=%s value=%s) " +
                                        "meta(partition=%d, offset=%d)\n",
                                record.key(), record.value(), metadata.partition(), metadata.offset());
                    }
                });

                // Wait for 1 minute before sending the next record
                Thread.sleep(60000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
