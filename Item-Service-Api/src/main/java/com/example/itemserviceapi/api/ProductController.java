package com.example.itemserviceapi.api;


import com.example.itemserviceapi.dto.CustomerDto;
import com.example.itemserviceapi.dto.ProductDto;
import com.example.itemserviceapi.service.ProductService;
import com.example.itemserviceapi.util.StandardResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

    private final ProductService productService;


    @Autowired
   RestTemplate  restTemplate;

    public ProductController(ProductService productService) {
        this.productService = productService;

    }

  //  @PostMapping
    public ResponseEntity<StandardResponseEntity> createProduct(@RequestBody ProductDto productDto){
        productService.createProduct(productDto);
        return new ResponseEntity<>(
                new StandardResponseEntity(201,"product saved!",productDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "get-product-id/{id}")
    public ProductDto findByProduct(@PathVariable long id){
        ProductDto product = productService.findByProduct(id);
        return product;
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<StandardResponseEntity> findCustomerById(@PathVariable long id){
        CustomerDto  all = restTemplate.getForObject("http://localhost:8001/api/v1/customers/find-by-id/"+id, CustomerDto.class);
        return new ResponseEntity<>(
                new StandardResponseEntity(201,"saved",all), HttpStatus.CREATED
        );
    }

    @PostMapping()
    public String  saveCustomer(@RequestBody CustomerDto dto){
     return    restTemplate.postForObject("http://localhost:8001/api/v1/customers",dto,String.class);
    }


}

