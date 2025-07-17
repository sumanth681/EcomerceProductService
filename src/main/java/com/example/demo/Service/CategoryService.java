package com.example.demo.Service;

import com.example.demo.DTO.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategorys() throws IOException;
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getAllCategorysByJpa();
}
