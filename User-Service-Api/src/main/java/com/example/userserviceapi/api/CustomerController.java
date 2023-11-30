package com.example.userserviceapi.api;


import com.example.userserviceapi.dto.CustomerDto;
import com.example.userserviceapi.dto.ResponseCustomerDto;
import com.example.userserviceapi.service.CustomerService;
import com.example.userserviceapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createCustomer(@RequestBody CustomerDto dto){
        customerService.saveCustomer(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"saved",null), HttpStatus.CREATED
        );
    }

   /* @PostMapping
    public String saveCustomer(@RequestBody CustomerDto dto){
        customerService.saveCustomer(dto);
        return "save customer";
    }*/

    @GetMapping("/find-by-id/{id}")
    public CustomerDto findCustomerById(@PathVariable long id){
        CustomerDto all = customerService.findCustomerById(id);
       return all;
    }





}
