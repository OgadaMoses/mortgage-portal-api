package com.mortgage.portal_api.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoanEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public LoanEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLoanEvent(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
