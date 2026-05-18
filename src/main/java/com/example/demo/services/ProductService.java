package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product addProduct(ProductRequestDto productDto) {
        
        var product = Product
                .builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .resourceId(UUID.randomUUID())
                .build();
                
        return productRepository.addProduct(product);
    }
}
