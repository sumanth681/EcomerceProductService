package com.example.demo.Gateway;

import com.example.demo.DTO.ProductCategoriesResponseDTO;
import com.example.demo.DTO.ProductsItem;
//import org.springframework.context.annotation.Primary;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component("MyClassChoice")
//@Primary
public class ProductCategoriesAnotherGatewayService implements ProductCategoriesGateway{
    private final RestTemplateBuilder restTemplateBuilder;

    public ProductCategoriesAnotherGatewayService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<ProductsItem> getAllProductCategories() throws Exception {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.in/api/products/category?type=mobile";
        ResponseEntity<ProductCategoriesResponseDTO> responseEntity = restTemplate.getForEntity(url, ProductCategoriesResponseDTO.class);
        if(responseEntity == null || responseEntity.getBody() == null) {
            throw new Exception("Failed to fetch product categories");

        }
        return responseEntity.getBody().getProducts()
                .stream()
                .map(item -> ProductsItem.builder()
                        .id(item.getId())
                        .title(item.getTitle())
                        .price(item.getPrice())
                        .description(item.getDescription())
                        .category(item.getCategory())
                        .image(item.getImage())
                        .brand(item.getBrand())
                        .color(item.getColor())
                        .discount(item.getDiscount())
                        .model(item.getModel())
                        .onSale(item.isOnSale())
                        .build())
                .toList();
    }
}

