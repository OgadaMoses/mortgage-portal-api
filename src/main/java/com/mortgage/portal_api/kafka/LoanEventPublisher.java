package com.mortgage.portal_api.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoanEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public LoanEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishLoanUpdateEvent(String message) {
        kafkaTemplate.send("loan-events", message);  
    }
}
