package com.example.demo.Service;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.ProductWithCategoryDTO;
import com.example.demo.Gateway.ProductGateway;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductCategory{
    private ProductGateway productGateway;

    public ProductService(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductDTO getAllProductByID(long id) throws Exception {
        return this.productGateway.getPrductById(id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception {
        return null;
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategoryById(long id) {
        return null;
    }
}
