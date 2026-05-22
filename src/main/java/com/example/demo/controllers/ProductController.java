package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProductDto;
import com.example.demo.facade.IProductFacade;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.models.ProductRequestModel;
import com.example.demo.models.ProductResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductFacade productFacade;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductResponseModel>> findAll() {
        return ResponseEntity.ok(
                productMapper.toProductResponseModelList(productFacade.getAll())
        );
    }

    @PostMapping
    public ProductDto save(@Valid @RequestBody ProductRequestModel productRequestModel) {
        var dto = productMapper.toProductRequestDto(productRequestModel);
        return productFacade.addProduct(dto);
    }

    @PutMapping(path = "/{resourceId}")
    public ProductDto update(@PathVariable("resourceId") UUID resourceId,
            @RequestBody ProductRequestModel productRequestModel) {
        var dto = productMapper.toProductRequestDto(productRequestModel);
        return productFacade.updateProduct(resourceId, dto);
    }

    @GetMapping(path = "/{resourceId}")
    public ProductDto findById(@PathVariable("resourceId") UUID resourceId) {
        return productFacade.getByResourceId(resourceId);
    }

}
