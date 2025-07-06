package com.example.demo.Gateway;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.ProductResponseDTO;
import com.example.demo.Gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;


@Component
public class ProductGatewayService  implements  ProductGateway{
    private final FakeStoreProductApi fakeStoreProductApi;

    public ProductGatewayService(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public ProductDTO getPrductById(long id) throws Exception {
        ProductResponseDTO response = this.fakeStoreProductApi.getAllProductByID(id).execute().body();
        if(response == null){
            throw new Exception("Product not found");
        }
        return response.getProduct();

    }
}
