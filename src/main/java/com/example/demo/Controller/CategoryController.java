package com.example.demo.Controller;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.Service.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService iCategoryService;

    public CategoryController(@Qualifier("CategoryServiceJPA") CategoryService categoryService) {
        this.iCategoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws IOException {
        List<CategoryDTO> result =  iCategoryService.getAllCategorys();
        return ResponseEntity.created(null).body(result);
    }

    @PostMapping("/addCategory")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) throws IOException {
        return iCategoryService.createCategory(categoryDTO);
    }
    @GetMapping("/getAllCategorys")
    public ResponseEntity<List<CategoryDTO>> getAllCategorys() throws IOException {
        List<CategoryDTO> result = iCategoryService.getAllCategorysByJpa();
        return ResponseEntity.ok(result);
    }
}
