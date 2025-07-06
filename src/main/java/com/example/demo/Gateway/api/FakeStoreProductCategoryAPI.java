package com.example.demo.Gateway.api;

import com.example.demo.DTO.ProductCategoriesResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FakeStoreProductCategoryAPI {
    @GET("products/category?type=mobile")
    Call<ProductCategoriesResponseDTO> getAllProductCategories() throws Exception;

}
