package com.example.monogo.poc.postgresql.repository;

import com.example.monogo.poc.postgresql.model.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailRepository extends JpaRepository<EmployeeDetail, String> {

    public long count();
}
