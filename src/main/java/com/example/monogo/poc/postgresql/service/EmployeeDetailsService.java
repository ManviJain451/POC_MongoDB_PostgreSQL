package com.example.monogo.poc.postgresql.service;

import com.example.monogo.poc.postgresql.dto.EmployeeDetailsDto;
import com.example.monogo.poc.postgresql.model.EmployeeDetail;
import com.example.monogo.poc.postgresql.repository.EmployeeDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeDetailsService {

    private final EmployeeDetailRepository employeeRepository;

    public void createEmployee(EmployeeDetailsDto dto){
        EmployeeDetail employee = EmployeeDetail.builder()
                .name(dto.getName())
                .department(dto.getDepartment())
                .salary(dto.getSalary())
                .build();

        employeeRepository.save(employee);
    }

    public List<EmployeeDetail> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
