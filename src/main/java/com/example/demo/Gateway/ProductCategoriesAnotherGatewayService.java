package com.example.demo.Gateway;

import com.example.demo.DTO.ProductsItem;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("sumanth")
//@Primary
public class ProductCategoriesAnotherGatewayService implements ProductCategoriesGateway{
    @Override
    public List<ProductsItem> getAllProductCategories() throws Exception {
        return List.of();
    }
}

