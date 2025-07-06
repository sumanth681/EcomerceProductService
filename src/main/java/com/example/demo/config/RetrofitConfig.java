package com.example.demo.config;

import com.example.demo.Gateway.api.FakeStoreCategoryApi;
import com.example.demo.Gateway.api.FakeStoreProductApi;
import com.example.demo.Gateway.api.FakeStoreProductCategoryAPI;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreCategoryApi.class);
    }

    @Bean
    public FakeStoreProductApi fakeStoreProductApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreProductApi.class);
    }

    @Bean
    public FakeStoreProductCategoryAPI fakeStoreProductCategoryAPI(Retrofit retrofit) {
        return retrofit.create(FakeStoreProductCategoryAPI.class);
    }



}
