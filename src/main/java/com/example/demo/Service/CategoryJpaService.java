package com.example.demo.Service;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.CategoryWithProductsDTo;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.CategoryNotFoundException;
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
        return  categoryRepository.findAll()
                .stream().map(CategoryMapper::mapEnt)
                .toList();
    }

    @Override
    public CategoryDTO getCategoryById(long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::mapEnt)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
    }

    @Override
    public CategoryDTO getCategoryByName(String name) throws IOException {
        return categoryRepository.findByName(name)
                .map(CategoryMapper::mapEnt)
                .orElseThrow(()-> new RuntimeException("Category not found with name: " + name));
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

    @Override
    public CategoryWithProductsDTo getAllProductsByCategoryId(long id) {

        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        CategoryDTO categoryDTO = CategoryMapper.mapEnt(categoryEntity);

        List<ProductDTO> productEntities = categoryEntity.getProductEntities()
                .stream()
                .map(ProductMapper::mapENT)
                .toList();

        return  CategoryMapper.mapIt(categoryDTO , productEntities);
    }




}
