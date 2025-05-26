package com.example.monogo.poc.mongo.controller;

import com.example.monogo.poc.mongo.dto.EmployeeDto;
import com.example.monogo.poc.mongo.model.Employee;
import com.example.monogo.poc.mongo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Employee> getEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(
            @RequestParam String department,
            @RequestParam String city
    ) {
        return employeeService.findActiveInCity(department, city);
    }

    @GetMapping("/employees/query")
    public List<Employee> getEmployeesThroughQuery(
            @RequestParam String department,
            @RequestParam String city
    ) throws Exception {
        return employeeService.findActiveInCityThroughQuery(department, city);
    }


    @GetMapping("/employees/projection")
    public List<EmployeeDto> getEmployeesThroughProjection(
            @RequestParam String department,
            @RequestParam String city
    ) throws Exception {
        return employeeService.findThroughProjection(department, city);
    }
}
