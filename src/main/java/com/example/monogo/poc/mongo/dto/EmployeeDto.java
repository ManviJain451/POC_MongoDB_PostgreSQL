package com.example.monogo.poc.mongo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private String name;
    private String department;
    private Double salary;
}
