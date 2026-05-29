package com.example.demo.dtos;

import java.util.UUID;

public record UserDto(UUID resourceID ,
                         String name) {
}