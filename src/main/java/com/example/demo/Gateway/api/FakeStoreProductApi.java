package com.example.demo.Gateway.api;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.ProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreProductApi {
    @GET("products/{id}")
    Call<ProductResponseDTO> getAllProductByID(@Path("id") long id) throws Exception;
}
