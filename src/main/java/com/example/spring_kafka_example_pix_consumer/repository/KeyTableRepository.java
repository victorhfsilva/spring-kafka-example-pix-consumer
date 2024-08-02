package com.example.spring_kafka_example_pix_consumer.repository;

import com.example.spring_kafka_example_pix_consumer.model.KeyTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyTableRepository extends JpaRepository<KeyTable, Integer> {
    KeyTable findByKeyValue(String key);
}
