package com.example.demo.Service;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service(value = "CategoryServiceJPA")
public class CategoryJpaService implements CategoryService{

    private  final  CategoryRepository categoryRepository;

    public CategoryJpaService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategorys() throws IOException {
        return List.of();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        CategoryEntity response = categoryRepository.save(CategoryMapper.mapDto(categoryDTO));
        return CategoryMapper.mapEnt(response);
    }

    @Override
    public List<CategoryDTO> getAllCategorysByJpa() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return  categoryEntities.stream().map(CategoryMapper::mapEnt)
                .toList();
    }
}
