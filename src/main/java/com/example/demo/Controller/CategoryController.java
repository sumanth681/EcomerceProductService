package com.example.demo.Controller;


import com.example.demo.DTO.CategoryDTO;
import com.example.demo.Service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService iCategoryService;


    public CategoryController(CategoryService categoryService) {
        this.iCategoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws IOException {
        List<CategoryDTO> result =  iCategoryService.getAllCategorys();
        return ResponseEntity.created(null).body(result);
    }

}
