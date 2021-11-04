package com.example.producerservice;
import java.util.Date;
import java.util.Random;

import org.springframework.kafka.core.KafkaTemplate;

import com.example.producerservice.model.Event;

public class TestTask implements Runnable {

    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "test-message";

    public TestTask(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    private int count = 0;
    public void run() {
        try {
            while (true) {
                Thread.sleep(30000);
                Event event= new Event(count,new Date(System.currentTimeMillis()));
                kafkaTemplate.send(TOPIC, gson.toJson(event));
                System.out.println("published");
                count += 1;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}