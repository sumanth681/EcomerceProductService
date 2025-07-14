package com.example.demo.Controller;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.Service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class ProductController {
    private final ProductCategory productCategory;

    public ProductController(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") long id) throws  Exception{ProductDTO result = productCategory.getAllProductByID(id);
        return ResponseEntity.ok(result);
    }


}