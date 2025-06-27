package com.example.demo.Gateway;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.FakeStoreCategoryResponseDTO;
import com.example.demo.Gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements  CategoryGateway{

   private FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }


    @Override
    public List<CategoryDTO> getAllCategories()  throws IOException {
         FakeStoreCategoryResponseDTO response =  fakeStoreCategoryApi.getAllProductCategories().execute().body();

         if(response == null){
             throw new IOException("Failed to fetch the Categories from the Fake Api Store");
         }
        return response.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}
