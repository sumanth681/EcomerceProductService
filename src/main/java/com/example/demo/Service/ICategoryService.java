package com.example.demo.Service;

import com.example.demo.DTO.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategorys() throws IOException;
}
