package com.example.demo.facade;

import java.util.List;

import com.example.demo.dtos.ProductDto;

public interface IProductFacade {

    List<ProductDto> getAll();
}
