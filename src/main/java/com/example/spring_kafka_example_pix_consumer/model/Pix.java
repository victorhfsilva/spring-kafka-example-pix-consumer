package com.example.spring_kafka_example_pix_consumer.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String identifier;

    @Column(nullable = false)
    private String originKey;

    @Column(nullable = false)
    private String destinyKey;

    @Column(nullable = false)
    private Double pixValue;

    @Column(nullable = false)
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private PixStatus status;

    public enum PixStatus {
        EM_PROCESSAMENTO, PROCESSADO, ERRO
    }
}
