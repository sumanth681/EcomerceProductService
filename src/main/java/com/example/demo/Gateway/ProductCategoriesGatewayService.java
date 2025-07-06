package com.example.demo.Gateway;

import com.example.demo.DTO.ProductCategoriesResponseDTO;
import com.example.demo.DTO.ProductsItem;
import com.example.demo.Gateway.api.FakeStoreProductCategoryAPI;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ProductCategoriesGatewayService implements ProductCategoriesGateway{

    private final FakeStoreProductCategoryAPI fakeStoreProductCategoryAPI;

    public ProductCategoriesGatewayService(FakeStoreProductCategoryAPI fakeStoreProductCategoryAPI) {
        this.fakeStoreProductCategoryAPI = fakeStoreProductCategoryAPI;
    }

    @Override
    public List<ProductsItem> getAllProductCategories() throws Exception {
        ProductCategoriesResponseDTO response = this.fakeStoreProductCategoryAPI.getAllProductCategories().execute().body();
        if(response == null){
            throw new Exception("Failed to fetch product categories");
        }
        return  response.getProducts()
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
