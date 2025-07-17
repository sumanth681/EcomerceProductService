package com.example.demo.mapper;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ProductEntity;

public class ProductMapper {
    public static ProductDTO  mapENT(ProductEntity productEntity){
        return ProductDTO.builder()
                .title(productEntity.getTitle())
                .id(productEntity.getId())
                .price(productEntity.getPrice())
                .description(productEntity.getDescription())
                .categoryId(productEntity.getCategory().getId())
                .image(productEntity.getImage())
                .color(productEntity.getColor())
                .discount(productEntity.getDiscount())
                .onSale(productEntity.isOnSale())
                .model(productEntity.getModel())
                .brand(productEntity.getBrand())
                .build();
    }
    public static ProductEntity mapDTO(ProductDTO productDTO , CategoryEntity categoryEntity){
        return ProductEntity.builder()
                .title(productDTO.getTitle())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .category(categoryEntity)
                .image(productDTO.getImage())
                .color(productDTO.getColor())
                .discount(productDTO.getDiscount())
                .onSale(productDTO.isOnSale())
                .model(productDTO.getModel())
                .brand(productDTO.getBrand())
                .build();
    }

}
