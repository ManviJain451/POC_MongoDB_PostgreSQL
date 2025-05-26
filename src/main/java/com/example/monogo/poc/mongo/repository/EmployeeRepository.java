package com.example.monogo.poc.mongo.repository;

import com.example.monogo.poc.mongo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    public long count();

    @Query(value = "{ 'department': ?0, 'active': true, 'address.city': ?1 }", fields = "{ 'name': 1, 'salary': 1, 'skills': 1 }")
    List<Employee> findActiveInCityWithProjection(String department, String city);
}
