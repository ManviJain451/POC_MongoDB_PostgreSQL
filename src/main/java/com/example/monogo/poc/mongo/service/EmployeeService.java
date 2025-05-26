package com.example.monogo.poc.mongo.service;

import com.example.monogo.poc.mongo.dto.EmployeeDto;
import com.example.monogo.poc.mongo.model.Address;
import com.example.monogo.poc.mongo.model.Employee;
import com.example.monogo.poc.mongo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final MongoTemplate mongoTemplate;

    public void createEmployee(EmployeeDto dto){

        Address address = Address.builder()
                .street(dto.getStreet())
                .state(dto.getState())
                .city(dto.getCity())
                .zipCode(dto.getZipCode())
                .build();

        Employee employee = Employee.builder()
                .name(dto.getName())
                .department(dto.getDepartment())
                .salary(dto.getSalary())
                .position(dto.getPosition())
                .active(true)
                .skills(dto.getSkills())
                .address(address)
                .build();

        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> findActiveInCity(String department, String city) {
        Query query = new Query();
        query.addCriteria(
                Criteria.where("department").is(department)
                        .and("active").is(true)
                        .and("address.city").is(city)
        );

        System.out.println(">>> Mongo Query: " + query);
        return mongoTemplate.find(query, Employee.class);
    }

    public List<Employee> findActiveInCityThroughQuery(String department, String city) throws Exception {
        Query query = loadQueryFromJsFile(department, city);
        return mongoTemplate.find(query, Employee.class);
    }


    public Query loadQueryFromJsFile(String department, String city) throws Exception {
        String rawJs = Files.readString(Paths.get("src/main/java/com/example/monogo/poc/mongo/query/query-employees.js"));
        rawJs = rawJs.replace("{{department}}", department)
                .replace("{{city}}", city);

        Document queryDoc = Document.parse(rawJs);

        Query query = new BasicQuery(queryDoc);
        return query;
    }


    public List<EmployeeDto> findThroughProjection(String department, String city){
        List<Employee> employees = employeeRepository.findActiveInCityWithProjection(department, city);
        return employees.stream()
                .map(emp -> {
                    EmployeeDto dto = new EmployeeDto();
                    dto.setName(emp.getName());
                    dto.setSalary(emp.getSalary());
                    dto.setSkills(emp.getSkills());
                    return dto;
                }).collect(Collectors.toList());
    }
}
