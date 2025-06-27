package com.example.demo.Service;


import com.example.demo.DTO.CategoryDTO;
import com.example.demo.Gateway.CategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements  ICategoryService{

    private CategoryGateway categoryGateway;

    public FakeStoreCategoryService(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }


    @Override
    public List<CategoryDTO> getAllCategorys () throws IOException{
        return this.categoryGateway.getAllCategories();
    }
}
