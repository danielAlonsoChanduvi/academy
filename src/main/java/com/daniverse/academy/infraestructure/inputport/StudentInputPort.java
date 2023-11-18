package com.daniverse.academy.infraestructure.inputport;

import com.daniverse.academy.domain.Familiar;
import com.daniverse.academy.domain.Student;
import com.daniverse.academy.infraestructure.model.StudentRequest;

import java.util.List;

public interface StudentInputPort {

    List<Familiar> getFamiliarByStudent(String idStudent);

    List<Student> getStudentByName(String nameStudent);

    Student getStudentByDocumentNumber(String documentNumber);

    String addStudent(StudentRequest studentRequest);

    String removeStudent(String documentNumber);

    List<Student> getAllStudents();

    String addFamiliarToStudent(String id, Familiar familiar);



}
