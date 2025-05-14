package com.example.monogo.poc.postgresql.controller;

import com.example.monogo.poc.postgresql.dto.EmployeeDetailsDto;
import com.example.monogo.poc.postgresql.model.EmployeeDetail;
import com.example.monogo.poc.postgresql.service.EmployeeDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2")
public class EmployeeDetailsController {

    private final EmployeeDetailsService employeeService;

    @PostMapping("/employee")
    public void saveEmployee(@RequestBody EmployeeDetailsDto dto){
        employeeService.createEmployee(dto);
    }

    @GetMapping("/employee")
    public List<EmployeeDetail> getEmployee(){
        return employeeService.getAllEmployees();
    }
}
