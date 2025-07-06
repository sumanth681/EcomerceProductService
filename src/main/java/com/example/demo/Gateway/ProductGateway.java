package com.example.demo.Gateway;

import com.example.demo.DTO.ProductDTO;

public interface ProductGateway {
    ProductDTO getPrductById(long id) throws Exception;
}
