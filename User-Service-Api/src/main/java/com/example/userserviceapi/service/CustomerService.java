package com.example.userserviceapi.service;


import com.example.userserviceapi.dto.CustomerDto;
import com.example.userserviceapi.dto.ResponseCustomerDto;

public interface CustomerService {

    public void saveCustomer(CustomerDto dto);

    CustomerDto findCustomerById(Long id);

}
