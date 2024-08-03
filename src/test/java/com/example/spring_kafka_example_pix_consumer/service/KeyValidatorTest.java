package com.example.spring_kafka_example_pix_consumer.service;

import com.example.spring_kafka_example_pix_consumer.fixture.KeyTableFixture;
import com.example.spring_kafka_example_pix_consumer.fixture.PixFixture;
import com.example.spring_kafka_example_pix_consumer.model.KeyTable;
import com.example.spring_kafka_example_pix_consumer.model.Pix;
import com.example.spring_kafka_example_pix_consumer.repository.KeyTableRepository;
import com.example.spring_kafka_example_pix_consumer.service.impl.KeyValidatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KeyValidatorTest {

    @InjectMocks
    private KeyValidatorImpl keyValidator;

    @Mock
    private KeyTableRepository repository;

    @Test
    void successfullyValidateKeyTest(){
        KeyTable originKey = KeyTableFixture.defaultBuilder();
        KeyTable destinyKey = KeyTableFixture.secondaryBuilder();
        Pix pix = PixFixture.defaultBuilder();

        when(repository.findByKeyValue(pix.getOriginKey())).thenReturn(originKey);
        when(repository.findByKeyValue(pix.getDestinyKey())).thenReturn(destinyKey);

        keyValidator.validateKey(pix);

        assertEquals(pix.getStatus(), Pix.PixStatus.PROCESSADO);
    }

    @Test
    void unsuccessfulValidateKeyTest(){
        KeyTable originKey = KeyTableFixture.defaultBuilder();
        Pix pix = PixFixture.defaultBuilder();

        when(repository.findByKeyValue(pix.getOriginKey())).thenReturn(originKey);
        when(repository.findByKeyValue(pix.getDestinyKey())).thenReturn(null);

        keyValidator.validateKey(pix);

        assertEquals(pix.getStatus(), Pix.PixStatus.ERRO);
    }

}
