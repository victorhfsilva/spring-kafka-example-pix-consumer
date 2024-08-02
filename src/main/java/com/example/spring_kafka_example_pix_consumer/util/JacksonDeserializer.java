package com.example.spring_kafka_example_pix_consumer.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class JacksonDeserializer<T> implements Deserializer<T> {

    private final ObjectMapper objectMapper;
    private Class<T> tClass;

    public JacksonDeserializer() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        tClass = (Class<T>) configs.get("value.deserializer.type");
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }

        try {
            return objectMapper.readValue(data, tClass);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing JSON", e);
        }
    }

}
