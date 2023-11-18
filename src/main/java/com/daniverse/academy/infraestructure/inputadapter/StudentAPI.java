package com.daniverse.academy.infraestructure.inputadapter;

import com.daniverse.academy.domain.Familiar;
import com.daniverse.academy.domain.Student;
import com.daniverse.academy.infraestructure.inputport.StudentInputPort;
import com.daniverse.academy.infraestructure.model.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentAPI {

    @Autowired
    private StudentInputPort studentInputPort;

    @GetMapping(produces = "application/json")
    public List<Student> getAllStudent() {
        return studentInputPort.getAllStudents();
    }

    @PostMapping(produces = "application/json",consumes = "application/json")
    public String addStudent( @Valid @RequestBody StudentRequest studentRequest) {
        return studentInputPort.addStudent(studentRequest);
    }

    @DeleteMapping(value = "/{documentNumber}", produces = "application/json")
    public String removeStudent(@PathVariable  String documentNumber) {
        return studentInputPort.removeStudent(documentNumber);
    }

    @GetMapping(value = "/namestudent/{nameStudent}", produces = "application/json")
    public List<Student> getStudentByName(@PathVariable String nameStudent) {
        return studentInputPort.getStudentByName(nameStudent);
    }

    @GetMapping(value = "/documentnumber/{documentNumber}", produces = "application/json")
    public Student getStudentByDocumentNumber(@PathVariable String documentNumber) {
        return studentInputPort.getStudentByDocumentNumber(documentNumber);
    }

    @PostMapping(value = "/familiar/{idStudent}", produces = "application/json")
    public String addFamiliarToStudent(
            @PathVariable String idStudent,
            @RequestBody Familiar familiar
            ) {
        return studentInputPort.addFamiliarToStudent(idStudent,familiar);
    }

    @GetMapping(value = "/familiar/{idStudent}", produces = "application/json")
    public List<Familiar> getFamiliarByStudent(@PathVariable String idStudent) {
        return studentInputPort.getFamiliarByStudent(idStudent);
    }



}
