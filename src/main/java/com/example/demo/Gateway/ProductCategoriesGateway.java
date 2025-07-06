package com.example.demo.Gateway;

import com.example.demo.DTO.ProductsItem;

import java.util.List;

public interface ProductCategoriesGateway {
    List<ProductsItem> getAllProductCategories() throws Exception;
}
