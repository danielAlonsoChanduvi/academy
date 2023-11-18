package com.daniverse.academy.infraestructure.outputport;

import com.daniverse.academy.domain.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);
    Student getById(String idStudent);
    List<Student> getAllStudent();

}
