package com.example.spring_kafka_example_pix_consumer.service;

import com.example.spring_kafka_example_pix_consumer.fixture.PixFixture;
import com.example.spring_kafka_example_pix_consumer.fixture.PixResponseDtoFixture;
import com.example.spring_kafka_example_pix_consumer.model.Pix;
import com.example.spring_kafka_example_pix_consumer.model.dto.PixResponseDto;
import com.example.spring_kafka_example_pix_consumer.repository.PixRepository;
import com.example.spring_kafka_example_pix_consumer.service.impl.PixValidatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PixValidatorTest {

    @InjectMocks
    private PixValidatorImpl pixValidator;

    @Mock
    private PixRepository pixRepository;

    @Mock
    private KeyValidator keyValidator;

    @Test
    void validatePixTest(){
        Pix pix = PixFixture.defaultBuilder();
        PixResponseDto pixResponseDto = PixResponseDtoFixture.defaultBuilder();

        when(pixRepository.findByIdentifier(pixResponseDto.getIdentifier())).thenReturn(pix);

        pixValidator.validatePix(pixResponseDto);

        verify(pixRepository).save(eq(pix));
    }
}
