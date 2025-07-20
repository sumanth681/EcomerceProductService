package com.example.demo.Controller;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.CategoryWithProductsDTo;
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
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws IOException {

        if(name != null && !name.isEmpty()){
            CategoryDTO categoryDTO = iCategoryService.getCategoryByName(name);
            return ResponseEntity.ok(categoryDTO);
        }
        List<CategoryDTO> result =  iCategoryService.getAllCategorys();
        return ResponseEntity.created(null).body(result);
    }

    @GetMapping("/getCategory/{id}")
    public CategoryDTO getCategoryBuId(@PathVariable("id") long id) throws IOException {


        return iCategoryService.getCategoryById(id);

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

    @GetMapping("/getCategory{id}/withProducts")
    public ResponseEntity<CategoryWithProductsDTo> getCategoryWithProductsById(@PathVariable("id") long id) throws IOException {
        CategoryWithProductsDTo result = iCategoryService.getAllProductsByCategoryId(id);
        return ResponseEntity.ok(result);
    }
}
