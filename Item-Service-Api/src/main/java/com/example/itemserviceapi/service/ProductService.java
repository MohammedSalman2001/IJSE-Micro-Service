package com.example.itemserviceapi.service;


import com.example.itemserviceapi.dto.ProductDto;

public interface ProductService {
    public void createProduct(ProductDto dto);


    public ProductDto findByProduct(long id);
}
