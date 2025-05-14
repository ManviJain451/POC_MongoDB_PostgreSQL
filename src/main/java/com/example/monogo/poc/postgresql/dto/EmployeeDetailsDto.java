package com.example.monogo.poc.postgresql.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDetailsDto {
    private String name;
    private String department;
    private Double salary;
}
