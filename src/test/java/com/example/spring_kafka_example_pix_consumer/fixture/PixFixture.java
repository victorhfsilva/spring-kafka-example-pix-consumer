package com.example.spring_kafka_example_pix_consumer.fixture;

import com.example.spring_kafka_example_pix_consumer.model.Pix;

import java.time.LocalDateTime;

public interface PixFixture {
    static Pix defaultBuilder(){
        return builder().build();
    }

    private static Pix.PixBuilder builder(){
        return Pix.builder().id(1)
                .identifier("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454")
                .originKey("pix-123")
                .destinyKey("pix-321")
                .pixValue(24.5)
                .status(Pix.PixStatus.EM_PROCESSAMENTO)
                .paymentDate(LocalDateTime.of(2024,07,06,22,54,36));
    }

}
