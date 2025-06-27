package com.example.demo.Gateway;

import com.example.demo.DTO.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface CategoryGateway {
    List<CategoryDTO> getAllCategories() throws IOException;
}
