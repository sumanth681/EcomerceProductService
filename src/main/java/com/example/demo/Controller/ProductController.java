package com.example.demo.Controller;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class ProductController {
    private final ProductCategory productCategory;

    public ProductController(@Qualifier("productServiceJPA") ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") long id) throws  Exception{ProductDTO result = productCategory.getAllProductByID(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) throws Exception {
        ProductDTO result = productCategory.createProduct(productDTO);
        return ResponseEntity.ok(result);
    }

}