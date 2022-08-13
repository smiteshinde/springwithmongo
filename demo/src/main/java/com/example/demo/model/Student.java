package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Gender gender;

    private Address address;

    public Student(String firstName, String lastName, String email, Gender gender, List<String> favSubjects, BigDecimal spentInBooks, LocalDateTime created, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.favSubjects = favSubjects;
        this.spentInBooks = spentInBooks;
        this.created = created;
        this.address = address;
    }

    private List<String> favSubjects;
    private BigDecimal spentInBooks;
    private LocalDateTime created;
}
