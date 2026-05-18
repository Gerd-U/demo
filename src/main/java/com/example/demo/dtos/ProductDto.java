package com.example.demo.dtos;
import java.util.UUID;

import java.math.BigDecimal;

public record ProductDto(
        String name,
        String description,
        BigDecimal price,
        UUID resourceId) {
}
