package com.example.monogo.poc.mongo.repository;

import com.example.monogo.poc.mongo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    public long count();
}
