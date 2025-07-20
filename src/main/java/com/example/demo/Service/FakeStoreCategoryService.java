package com.example.demo.Service;


import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.CategoryWithProductsDTo;
import com.example.demo.Gateway.CategoryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService {

    private CategoryGateway categoryGateway;

    public FakeStoreCategoryService(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }


    @Override
    public List<CategoryDTO> getAllCategorys () throws IOException{
        return this.categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public List<CategoryDTO> getAllCategorysByJpa() {
        return List.of();
    }

    @Override
    public CategoryDTO getCategoryById(long id) {
        return null;
    }

    @Override
    public CategoryDTO getCategoryByName(String name) throws IOException {
        return null;
    }

    @Override
    public CategoryWithProductsDTo getAllProductsByCategoryId(long id){
        return null;
    }
}
