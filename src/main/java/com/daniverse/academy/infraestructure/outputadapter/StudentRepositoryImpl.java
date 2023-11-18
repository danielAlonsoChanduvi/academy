package com.daniverse.academy.infraestructure.outputadapter;

import com.daniverse.academy.domain.Student;
import com.daniverse.academy.infraestructure.outputport.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepositoryImpl implements StudentRepository {

    private List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public Student getById(String idStudent) {
        return students.stream().filter(student -> student.getId().equals(idStudent)).findAny().get();
    }
    @Override
    public List<Student> getAllStudent() {
        return students;
    }

}
