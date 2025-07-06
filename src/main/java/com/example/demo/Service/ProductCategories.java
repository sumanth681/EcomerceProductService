package com.example.demo.Service;

import com.example.demo.DTO.ProductsItem;

import java.util.List;

public interface ProductCategories {
    List<ProductsItem> getAllProductCategories() throws Exception;
}
