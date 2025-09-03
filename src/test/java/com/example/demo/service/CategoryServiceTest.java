package com.example.demo.service;


import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.CategoryWithProductsDTo;
import com.example.demo.Service.CategoryJpaService;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {


    @Mock
    public CategoryRepository categoryRepository;

    @InjectMocks
    public CategoryJpaService categoryService;

    private CategoryDTO categoryDTO;
    private Category category1;
    private Category category2;
    private Category category3;


    @BeforeEach
    void setUp() {
        categoryDTO = CategoryDTO.builder().name("Electronics").build();
        category1 = Category.builder().name("Electronics").build();
        category1.setId(1);
        category2 = Category.builder().name("Books").build();
        category2.setId(2);
        category3 = Category.builder().name("Clothing").build();
        category3.setId(3);
    }


    @Test
    @DisplayName("Should return all categories successfully")
    public  void getAllCategories_should_return_allCategories(){

        // Arrange
        List<Category> categories =  new ArrayList<>();
//        category1 = Category.builder().name("Electronics").build();
//        category1.setId(1);
//        category2 = Category.builder().name("Books").build();
//        category2.setId(2);
//        category3 = Category.builder().name("Clothing").build();
//        category3.setId(3);

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        when(categoryRepository.findAll()).thenReturn(categories);
        // Act
        List<CategoryDTO> result = categoryService.getAllCategorysByJpa();
        // Assert
        assertEquals(3, result.size());
        verify(categoryRepository, times(1)).findAll();
        System.out.println(category1.getName());
    }

    @Test
    @DisplayName("should return all the categories successfully")
    public  void getAllCategories_should_return_all_the_categories() throws IOException {

        List<Category> categories =  new ArrayList<>();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        when(categoryRepository.findAll()).thenReturn(categories);

        List<CategoryDTO> result = categoryService.getAllCategorys();

        assertEquals(3, result.size());
        verify(categoryRepository, times(1)).findAll();
        System.out.println(category3.getName());

    }

    @Test
    @DisplayName("Should return Empty List when there is no category")
    public  void getAllCategories_should_return_empty_list_when_no_category() {
        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        List<CategoryDTO> result = categoryService.getAllCategorysByJpa();
        assertEquals(0, result.size());
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should return category by id successfully")
    public  void getCategoryById_should_return_category_by_id(){
        // Arrange
        when(categoryRepository.findById(1L)).thenReturn(Optional.ofNullable(category1));

        // Act
        CategoryDTO result = categoryService.getCategoryById(1L);

        // Assert
        assertEquals("Electronics", result.getName());
        assertEquals(1L , result.getId());
        verify(categoryRepository , times(1)).findById(1L);

    }





    @Test
    @DisplayName("should return Category not found exception when category does not exist")
    public void getCategoryById_should_throw_exception_when_category_not_found(){
        long categoryId = 1L;
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());
        try {
            categoryService.getCategoryById(categoryId);
        } catch (CategoryNotFoundException e) {
            assertEquals("Category not found with id: " + categoryId, e.getMessage());
        }
        verify(categoryRepository, times(1)).findById(categoryId);

    }


    @Test
    @DisplayName("Should create and return category successfully")
    public  void createCategory_should_create_and_return_category(){
        // Arrange
        when(categoryRepository.save(any(Category.class))).thenReturn(category1);

        // Act
        CategoryDTO result = categoryService.createCategory(categoryDTO);
        // Assert
        assertEquals("Electronics", result.getName());
        verify(categoryRepository, times(1)).save(any(Category.class));


        System.out.println(category1.getName());
    }

    @Test
    public  void  getCategoryByName_should_return_category_by_name() throws IOException {
        //CategoryDTO categoryDTO = CategoryDTO.builder().name("Mobiles").build();
        Category category = Category.builder().name("Mobiles").build();

        // Arrange
        String name = "Mobiles";
        when(categoryRepository.findByName(name)).thenReturn(Optional.ofNullable(category));

        // Act
        CategoryDTO result = categoryService.getCategoryByName(name);

        // Assert
        assertEquals("Mobiles", result.getName());
        verify(categoryRepository, times(1)).findByName(name);
        System.out.println(category.getName());

    }

    @Test
    @DisplayName("Should return all products by category id successfully")
    public  void  getAllProductsByCategoryId_should_return_all_products_by_category_id(){
        // Arrange
        Category category = Category.builder().name("Mobiles").build();
        Long categoryId = 1L;
        Product product1 = Product.builder()
                .id(1)
                .title("iPhone 26")
                .brand("Apple")
                .model("A2633")
                .color("Black")
                .price(99999999)
                .description("Latest iPhone model")
                .discount(6)
                .category(category)
                .onSale(true)
                .image("https://example.com/iphone13.jpg")
                .build();
        //category.setproductEntities(List.of(product1));
        category.setProductEntities(List.of(product1));

        when(categoryRepository.findById(categoryId)).thenReturn(Optional.ofNullable(category));

        // Act
        CategoryWithProductsDTo result = categoryService.getAllProductsByCategoryId(categoryId);
        // Assert
        assertEquals("Mobiles", result.getName());
        assertEquals(1, result.getProducts().size());
        verify(categoryRepository, times(1)).findById(categoryId);
        System.out.println(result.getName());
        System.out.println(result.getProducts().get(0).getTitle());
    }





}
