package com.example.demo.facade;

import java.util.List;

import com.example.demo.dtos.ProductDto;
import com.example.demo.dtos.ProductRequestDto;

public interface IProductFacade {

    List<ProductDto> getAll();
    ProductDto addProduct(ProductRequestDto productDto);
}
