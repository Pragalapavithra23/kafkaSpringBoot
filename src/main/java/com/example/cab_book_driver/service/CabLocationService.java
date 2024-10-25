package com.example.cab_book_driver.service;

import com.example.cab_book_driver.constants.AppConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {

    @Bean
    public NewTopic topic() {
        return new NewTopic(AppConstants.CAB_LOCATION_TOPIC, 1, (short) 1);
    }

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public boolean updateLocation(String location){
        kafkaTemplate.send(AppConstants.CAB_LOCATION_TOPIC, location);
        return true;
    }
}
