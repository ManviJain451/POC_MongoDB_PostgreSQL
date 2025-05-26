package com.example.monogo.poc.mongo.model;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document("employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Employee {

    @Id
    private String id;

    private String name;
    private String department;
    private Double salary;

    private String position;

    @CreatedDate
    private LocalDate joiningDate;

    private Boolean active;
    private List<String> skills;
    private Address address;

}

