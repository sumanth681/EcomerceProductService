package com.example.demo.Service;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.CategoryWithProductsDTo;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategorys() throws IOException;
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getAllCategorysByJpa();
    CategoryDTO getCategoryById(long id);
    CategoryDTO getCategoryByName(String name) throws IOException;


    CategoryWithProductsDTo getAllProductsByCategoryId(long id);
}
