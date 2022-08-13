package com.example.demo.service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository repository;
    public List<Student> getAllStudents(){
        return repository.findAll();
    }
}
