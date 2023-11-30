package com.example.userserviceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ResponseCustomerDto {
    private CustomerDto customerDto;
    private ResponseOrderDto responseOrderDto;
}
