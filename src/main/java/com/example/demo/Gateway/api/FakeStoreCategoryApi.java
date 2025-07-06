package com.example.demo.Gateway.api;

import com.example.demo.DTO.CategoryResponseDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;

@Component
public interface FakeStoreCategoryApi {
    @GET("products/category")
    Call<CategoryResponseDTO> getAllProductCategories() throws IOException;
}
