package com.example.spring_kafka_example_pix_consumer.fixture;

import com.example.spring_kafka_example_pix_consumer.model.KeyTable;

public interface KeyTableFixture {
    static KeyTable defaultBuilder(){
        return builder().build();
    }

    static KeyTable secondaryBuilder() {
        return builder().id(2)
                .keyValue("pix-321")
                .build();
    }

    private static KeyTable.KeyTableBuilder builder() {
        return KeyTable.builder().id(1)
                .keyValue("pix-123");
    }
}
