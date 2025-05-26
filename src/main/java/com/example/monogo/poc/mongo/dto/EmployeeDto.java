package com.example.monogo.poc.mongo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {
    private String name;
    private String department;
    private Double salary;
    private String position;
    private List<String> skills;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
