package com.example.monogo.poc.mongo.service;

import com.example.monogo.poc.mongo.dto.EmployeeDto;
import com.example.monogo.poc.mongo.model.Employee;
import com.example.monogo.poc.mongo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void createEmployee(EmployeeDto dto){
        Employee employee = Employee.builder()
                .name(dto.getName())
                .department(dto.getDepartment())
                .salary(dto.getSalary())
                .build();

        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
