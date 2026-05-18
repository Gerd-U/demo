package com.example.demo.services;

import java.util.List;

import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.entities.Product;

public interface IProductService {

    List<Product> getAll();
    public Product addProduct (ProductRequestDto productDto);
}
