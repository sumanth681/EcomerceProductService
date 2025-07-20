package com.example.demo.Service;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.ProductWithCategoryDTO;

public interface ProductCategory {
    ProductDTO getAllProductByID(long id) throws Exception;

    ProductDTO createProduct(ProductDTO productDTO) throws Exception;

    ProductWithCategoryDTO getProductWithCategoryById(long id);

}
