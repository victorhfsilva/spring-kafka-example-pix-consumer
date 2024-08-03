package com.example.spring_kafka_example_pix_consumer.service;

import com.example.spring_kafka_example_pix_consumer.model.Pix;

public interface KeyValidator {
    void validateKey(Pix pix);
}
