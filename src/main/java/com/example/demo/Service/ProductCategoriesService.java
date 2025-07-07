package com.example.demo.Service;

import com.example.demo.DTO.ProductsItem;
import com.example.demo.Gateway.ProductCategoriesGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoriesService implements ProductCategories{
    private final  ProductCategoriesGateway productCategoriesGateway;
    public ProductCategoriesService(@Qualifier("MyClassChoice") ProductCategoriesGateway productCategories) {
        this.productCategoriesGateway = productCategories;
    }

    @Override
    public List<ProductsItem> getAllProductCategories() throws Exception {
        return productCategoriesGateway.getAllProductCategories();
    }
}
