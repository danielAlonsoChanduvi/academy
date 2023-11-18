package com.daniverse.academy.application;

import com.daniverse.academy.application.mapper.StudentMapper;
import com.daniverse.academy.application.validators.ValidationsStudentUseCase;
import com.daniverse.academy.domain.Familiar;
import com.daniverse.academy.domain.Student;
import com.daniverse.academy.infraestructure.exceptionhandler.BussinesRequestException;
import com.daniverse.academy.infraestructure.inputport.StudentInputPort;
import com.daniverse.academy.infraestructure.model.StudentRequest;
import com.daniverse.academy.infraestructure.outputport.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentUseCase implements StudentInputPort {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ValidationsStudentUseCase validationsStudentUseCase;


    @Override
    public List<Familiar> getFamiliarByStudent(String idStudent) {
        return studentRepository.getAllStudent().stream()
                .filter(student -> student.getId().equals(idStudent))
                .findFirst()
                .map(student -> student.getFamiliares())
                .orElseThrow(() -> new BussinesRequestException("BS004","the student is not present"));
    }

    @Override
    public List<Student> getStudentByName(String nameStudent) {
        return studentRepository.getAllStudent().stream()
                .filter(student -> student.getFullname().contains(nameStudent))
                .collect(Collectors.toList());
    }

    @Override
    public Student getStudentByDocumentNumber(String documentNumber) {
        return studentRepository.getAllStudent().stream()
                .filter(student -> student.getDocumentNumber().equals(documentNumber))
                .findAny()
                .get();
    }

    @Override
    public String addStudent(StudentRequest studentRequest) {
        validationsStudentUseCase.validateQuanitiyFamiliaresOfStudent(studentRequest);
        validationsStudentUseCase.validateTipoFamiliares(studentRequest);
        
        Student student = studentMapper.studentRequestToStudent(studentRequest);

        studentRepository.save(student);
        return "Student added";
    }


    @Override
    public String removeStudent(String documentNumber) {
        studentRepository.getAllStudent()
                .removeIf(student -> student.getDocumentNumber().equals(documentNumber));
        return "Student removed";
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudent();
    }

    @Override
    public String addFamiliarToStudent(String idStudent, Familiar familiar) {
        validationsStudentUseCase.validateTipoFamiliar(familiar);

        Student student = studentRepository.getAllStudent().stream()
                .filter(std -> std.getId().equals(idStudent))
                .findFirst()
                .get();

        student.getFamiliares().add(familiar);

        return "Familiar added to " + student.getFullname();
    }

}
