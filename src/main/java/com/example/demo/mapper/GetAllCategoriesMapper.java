package com.example.demo.mapper;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.CategoryResponseDTO;

import java.util.List;

public class GetAllCategoriesMapper {

    public static CategoryResponseDTO toFakeStoreCategoryDTO() {
        return null;
    }

    public static List<CategoryDTO> toCategoryDto(CategoryResponseDTO dto) {
        return dto.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }

}