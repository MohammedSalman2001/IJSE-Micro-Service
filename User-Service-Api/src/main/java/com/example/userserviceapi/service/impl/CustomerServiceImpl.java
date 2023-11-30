package com.example.userserviceapi.service.impl;



import com.example.userserviceapi.dto.CustomerDto;
import com.example.userserviceapi.dto.ResponseCustomerDto;
import com.example.userserviceapi.entity.Customer;
import com.example.userserviceapi.repo.CustomerRepo;
import com.example.userserviceapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;


    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;

    }

    @Override
    public void saveCustomer(CustomerDto dto) {
        customerRepo.save(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary()));
    }

    @Override
    public CustomerDto findCustomerById(Long id) {
        Customer selectedCustomer = customerRepo.findById(id).get();
        return new CustomerDto(selectedCustomer.getId(),selectedCustomer.getName(),selectedCustomer.getAddress(),selectedCustomer.getSalary());

    }



}
