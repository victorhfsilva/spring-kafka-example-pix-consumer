package com.example.spring_kafka_example_pix_consumer.service.impl;

import com.example.spring_kafka_example_pix_consumer.model.KeyTable;
import com.example.spring_kafka_example_pix_consumer.model.Pix;
import com.example.spring_kafka_example_pix_consumer.repository.KeyTableRepository;
import com.example.spring_kafka_example_pix_consumer.service.KeyValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KeyValidatorImpl implements KeyValidator {

    private KeyTableRepository keyTableRepository;

    @Override
    public void validateKey(Pix pix) {
        KeyTable origin = keyTableRepository.findByKeyValue(pix.getOriginKey());
        KeyTable destiny = keyTableRepository.findByKeyValue(pix.getDestinyKey());

        if (origin == null || destiny == null){
            pix.setStatus(Pix.PixStatus.ERRO);
        } else {
            pix.setStatus(Pix.PixStatus.PROCESSADO);
        }
    }
}
