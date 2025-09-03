package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import com.example.demo.Controller.CategoryController;
import com.example.demo.DTO.CategoryDTO;
import com.example.demo.Service.CategoryService;
import com.example.demo.exception.GlobalException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import org.springframework.http.MediaType;


@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @Mock
    private CategoryService iCategoryService;

    @InjectMocks
    private CategoryController categoryController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .setControllerAdvice(new GlobalException())
                .build();
    }

    @Test
    @DisplayName("GET /api/category/getAllCategories should return all categories")
    void getAllCategories_shouldReturnAllCategories() throws Exception {
        // Arrange
        List<CategoryDTO> categories = new ArrayList<>();
        categories.add(CategoryDTO.builder().name("Electronics").id(1).build());
        categories.add(CategoryDTO.builder().name("Books").id(2).build());
        categories.add(CategoryDTO.builder().name("Clothing").id(3).build());


        when(iCategoryService.getAllCategorysByJpa()).thenReturn(categories);

        // Act
        mockMvc.perform(get("/api/category/getAllCategories").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath( "$[0].id").value(1))
                .andExpect(jsonPath( "$[0].name").value("Electronics"))
                .andExpect(jsonPath( "$[1].id").value(2))
                .andExpect(jsonPath( "$[1].name").value("Books"))
                .andExpect(jsonPath( "$[2].id").value(3))
                .andExpect(jsonPath( "$[2].name").value("Clothing"));

        // Assert
        verify(iCategoryService, times(1)).getAllCategorysByJpa();
    }


}
