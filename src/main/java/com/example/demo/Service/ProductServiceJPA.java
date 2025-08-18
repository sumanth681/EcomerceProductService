package com.example.demo.Service;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.ProductWithCategoryDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service("productServiceJPA")
public class ProductServiceJPA  implements  ProductCategory{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProductServiceJPA(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO getAllProductByID(long id) {
        return  productRepository.findById(id)
                .map(ProductMapper:: mapENT)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception {
        Category category = categoryRepository.findById( (long) productDTO.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found with id: " + productDTO.getCategoryId()));

        Product productEntity = productRepository.save(ProductMapper.mapDTO(productDTO, category));
        return ProductMapper.mapENT(productEntity);
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategoryById(long id) {
        Product productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return ProductMapper.mapEntWithCategory(productEntity);
    }

}
