package com.example.demo.mapper;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.CategoryWithProductsDTo;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.entity.CategoryEntity;

import java.util.List;

public class CategoryMapper {
    public static CategoryDTO mapEnt(CategoryEntity categoryEntity){
        return CategoryDTO.builder().name(categoryEntity.getName())
                .id(categoryEntity.getId()).
                build();
    }
    public static CategoryEntity mapDto(CategoryDTO categoryDTO){
        return CategoryEntity.builder()
                .name(categoryDTO.getName())
                .build();
    }
    public static CategoryWithProductsDTo mapIt (CategoryDTO  categoryDTO , List<ProductDTO> products) {
        return CategoryWithProductsDTo.builder()
                .category_id(categoryDTO.getId())
                .name(categoryDTO.getName())
               // .category(categoryDTO)
                .products(products)
                .build();
    }
}
