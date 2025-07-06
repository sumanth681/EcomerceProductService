package com.example.demo.Controller;


import com.example.demo.DTO.ProductsItem;
import com.example.demo.Service.ProductCategories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.GET;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductCategoryController {

    private  final ProductCategories productCategories;

    public ProductCategoryController(ProductCategories productCategories) {
        this.productCategories = productCategories;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<ProductsItem>> getAllProductCategories() throws Exception {
        List<ProductsItem> result = productCategories.getAllProductCategories();
        return ResponseEntity.ok(result);
    }
}
