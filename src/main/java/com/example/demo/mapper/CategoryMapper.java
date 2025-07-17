package com.example.demo.mapper;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.entity.CategoryEntity;

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
}
