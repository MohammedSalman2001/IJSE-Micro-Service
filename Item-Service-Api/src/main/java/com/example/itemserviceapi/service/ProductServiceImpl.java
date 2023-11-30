package com.example.itemserviceapi.service;


import com.example.itemserviceapi.dto.ProductDto;
import com.example.itemserviceapi.entity.Product;
import com.example.itemserviceapi.repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public void createProduct(ProductDto dto) {
        Product customer = new Product(
                dto.getCode(),
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getQtyOnHand()
        );
        productRepo.save(customer);
    }

    @Override
    public ProductDto findByProduct(long id) {
        Product product = productRepo.findById(id).get();
        ProductDto productDto = new ProductDto(product.getCode(),product.getDescription(),product.getUnitPrice(),product.getQtyOnHand());
        return productDto;
    }


}
