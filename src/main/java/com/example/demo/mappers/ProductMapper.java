package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dtos.ProductDto;
import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.entities.Product;
import com.example.demo.models.ProductRequestModel;
import com.example.demo.models.ProductResponseModel;

@Component
public class ProductMapper {

    public ProductDto toProductDto(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductDto(product.getName(), product.getDescription(), product.getPrice(), product.getResourceId());
    }

    public List<ProductDto> toProductDtoList(List<Product> products) {
        if (products == null) {
            return null;
        }
        return products.stream()
                .map(this::toProductDto)
                .collect(Collectors.toList());
    }

    public ProductResponseModel toProductResponseModel(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }

        return new ProductResponseModel(
                productDto.name(),
                productDto.description(),
                productDto.price(),
                productDto.resourceId()
        );
    }

    public List<ProductResponseModel> toProductResponseModelList(List<ProductDto> productDtos) {
        if (productDtos == null) {
            return null;
        }

        return productDtos.stream()
                .map(this::toProductResponseModel)
                .collect(Collectors.toList());
    }

    public ProductRequestDto toProductRequestDto(ProductRequestModel product){
        if (product == null) {
            return null;
        }

        ProductRequestDto productDto = new ProductRequestDto();
        productDto.setName(product.name());
        productDto.setDescription(product.description());
        productDto.setName(product.name());

        return productDto;
    }
}
