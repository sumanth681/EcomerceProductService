package com.example.demo.Service;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.entity.ProductEntity;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service("productServiceJPA")
public class ProductServiceJPA  implements  ProductCategory{
    private final ProductRepository productRepository;
    public ProductServiceJPA(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO getAllProductByID(long id) throws Exception {
        return  productRepository.findById(id)
                .map(ProductMapper::productEntToDTO)
                .orElseThrow(() -> new Exception("Product not found with id: " + id));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception {
        ProductEntity productEntity = productRepository.save(ProductMapper.productDTOTOEnt(productDTO));
        return ProductMapper.productEntToDTO(productEntity);
    }

}
