package com.example.demo.Service;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ProductEntity;
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
    public ProductDTO getAllProductByID(long id) throws Exception {
        return  productRepository.findById(id)
                .map(ProductMapper:: mapENT)
                .orElseThrow(() -> new Exception("Product not found with id: " + id));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception {
        CategoryEntity category = categoryRepository.findById( (long) productDTO.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found with id: " + productDTO.getCategoryId()));

        ProductEntity productEntity = productRepository.save(ProductMapper.mapDTO(productDTO, category));
        return ProductMapper.mapENT(productEntity);
    }
    
}
