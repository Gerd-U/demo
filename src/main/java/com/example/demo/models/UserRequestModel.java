package com.example.demo.models;

import jakarta.validation.constraints.NotBlank;


public record UserRequestModel( 
@NotBlank(message = "El nombre es requerido") String name) {

}