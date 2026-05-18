package com.example.demo.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dtos.ProductDto;
import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.services.IProductService;

@Component
public class ProductFacade implements IProductFacade {

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> getAll() {
        return productMapper.toProductDtoList(productService.getAll());
    }

    @Override
    @Transactional
    public ProductDto addProduct(ProductRequestDto productDto) {
        var entity = productService.addProduct(productDto);
        return productMapper.toProductDto(entity);
    }

    @Override
    @Transactional
    public ProductDto updateProduct(UUID resourceId, ProductRequestDto product) {
        var entity = productService.updateProduct(resourceId, product);
        return productMapper.toProductDto(entity);
    }

}
