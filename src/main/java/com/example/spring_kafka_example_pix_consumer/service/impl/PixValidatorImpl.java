package com.example.spring_kafka_example_pix_consumer.service.impl;

import com.example.spring_kafka_example_pix_consumer.model.Pix;
import com.example.spring_kafka_example_pix_consumer.model.dto.PixResponseDto;
import com.example.spring_kafka_example_pix_consumer.repository.PixRepository;
import com.example.spring_kafka_example_pix_consumer.service.KeyValidator;
import com.example.spring_kafka_example_pix_consumer.service.PixValidator;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PixValidatorImpl implements PixValidator {

    private KeyValidator keyValidator;

    private PixRepository pixRepository;

    private static final String TOPIC = "pix-topic";

    private static final String GROUP_ID = "pix-group";

    @Override
    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    @RetryableTopic(
            backoff = @Backoff(value = 3000L),
            attempts = "5",
            autoCreateTopics = "true",
            include = Exception.class
    )
    public void validatePix(PixResponseDto pixResponseDto) {
        System.out.println("Received Pix: " + pixResponseDto.getIdentifier());

        Pix pix = pixRepository.findByIdentifier(pixResponseDto.getIdentifier());

        keyValidator.validateKey(pix);

        pixRepository.save(pix);
    }


}
