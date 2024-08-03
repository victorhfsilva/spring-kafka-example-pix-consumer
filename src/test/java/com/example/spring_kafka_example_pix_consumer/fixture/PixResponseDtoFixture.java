package com.example.spring_kafka_example_pix_consumer.fixture;


import com.example.spring_kafka_example_pix_consumer.model.Pix;
import com.example.spring_kafka_example_pix_consumer.model.dto.PixResponseDto;

import java.time.LocalDateTime;

public interface PixResponseDtoFixture {

    static PixResponseDto defaultBuilder(){
        return builder().build();
    }

    private static PixResponseDto.PixResponseDtoBuilder builder(){
        return PixResponseDto.builder().identifier("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454")
                .originKey("pix-123")
                .destinyKey("pix-321")
                .pixValue(24.5)
                .paymentDate(LocalDateTime.of(2024, 8, 1, 11, 0 ))
                .status(Pix.PixStatus.EM_PROCESSAMENTO);
    }

}
