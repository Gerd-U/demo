package com.example.demo.models;

import java.math.BigDecimal;


public record ProductResponseModel(
        String name,
        String description,
        BigDecimal price
) {
}