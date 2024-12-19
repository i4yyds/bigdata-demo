package com.bigdata.test;

import com.bigdata.common.bean.Metric;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Properties;
import java.util.List;
import java.util.Random;

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
                Metric metric = new Metric();
                metric.setId(new Random().nextInt(100000));
                metric.setTimestamp(System.currentTimeMillis());
                metric.setCloudId(0);
                metric.setIp("192.168.1.1");
                List<String> list = new ArrayList<>();
                list.add("11");
                list.add("12");
                list.add("13");
                metric.setPorts(list);

                // Convert Metric object to JSON string using fastjson
                String jsonString = JSON.toJSONString(metric);

                // Create a producer record
                ProducerRecord<String, String> record = new ProducerRecord<>("topic_port_strategy", jsonString);

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
