package com.example.spring_kafka_example_pix_consumer.service;

import com.example.spring_kafka_example_pix_consumer.model.dto.PixResponseDto;

public interface PixValidator {
    void validatePix(PixResponseDto pixResponseDto);
}
