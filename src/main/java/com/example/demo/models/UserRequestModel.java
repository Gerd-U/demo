package com.example.demo.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestModel(
        @NotBlank(message = "El nombre es requerido") String name,
        @NotNull(message = "La edad es requerida") @Min(value = 0, message = "La edad debe ser mayor o igual a 0") Integer age) {
}
