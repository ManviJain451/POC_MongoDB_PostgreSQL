package com.example.monogo.poc.controller;

import com.example.monogo.poc.dto.EmployeeDto;
import com.example.monogo.poc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public void saveEmployee(@RequestBody EmployeeDto dto){
        employeeService.createEmployee(dto);
    }

    @GetMapping("/employee")
    public void getEmployee(){
        employeeService.getAllEmployees();
    }
}
