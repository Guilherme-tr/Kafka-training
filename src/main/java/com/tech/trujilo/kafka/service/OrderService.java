package com.tech.trujilo.kafka.service;

import com.tech.trujilo.kafka.record.OrderRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderService {
    private final KafkaTemplate<String, OrderRecord> kafkaTemplate;

    private final Random random = new Random();

    public OrderService(KafkaTemplate<String, OrderRecord> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @SuppressWarnings("null")
    public void sendMessageOrder(OrderRecord orderRecord){
        int partition = random.nextInt(2);
        System.out.println("Send message to partition: " + partition);
        System.out.println("Sending order: " + orderRecord.name());
        kafkaTemplate.send("trujilo-order-processed", partition, null, orderRecord);
    }
}
