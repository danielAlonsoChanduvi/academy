package com.daniverse.academy.application.mapper;

import com.daniverse.academy.domain.Student;
import com.daniverse.academy.infraestructure.model.StudentRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class StudentMapper {

    public Student studentRequestToStudent(StudentRequest studentRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Student.builder()
                .id(studentRequest.getId())
                .fullname(studentRequest.getFullname())
                .gender(studentRequest.getGender())
                .birthdate(LocalDate.parse(studentRequest.getBirthdate(), formatter))
                .familiares(studentRequest.getFamiliares())
                .build();
    }

}
