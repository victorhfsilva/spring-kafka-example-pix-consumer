package com.example.spring_kafka_example_pix_consumer.model.dto;

import com.example.spring_kafka_example_pix_consumer.model.Pix;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PixResponseDto {
    private String identifier;
    private String originKey;
    private String destinyKey;
    private Double pixValue;
    private LocalDateTime paymentDate;
    private Pix.PixStatus status;
}