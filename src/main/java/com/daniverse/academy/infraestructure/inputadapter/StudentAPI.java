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

    @GetMapping
    public List<Student> getAllStudent() {
        return studentInputPort.getAllStudents();
    }

    @PostMapping
    public String addStudent( @Valid @RequestBody StudentRequest studentRequest) {
        return studentInputPort.addStudent(studentRequest);
    }

    @DeleteMapping("/{documentNumber}")
    public String removeStudent(@PathVariable  String documentNumber) {
        return studentInputPort.removeStudent(documentNumber);
    }

    @GetMapping("/namestudent/{nameStudent}")
    public List<Student> getStudentByName(@PathVariable String nameStudent) {
        return studentInputPort.getStudentByName(nameStudent);
    }

    @GetMapping("/documentnumber/{documentNumber}")
    public Student getStudentByDocumentNumber(@PathVariable String documentNumber) {
        return studentInputPort.getStudentByDocumentNumber(documentNumber);
    }

    @PostMapping("/familiar/{idStudent}")
    public String addFamiliarToStudent(
            @PathVariable String idStudent,
            @RequestBody Familiar familiar
            ) {
        return studentInputPort.addFamiliarToStudent(idStudent,familiar);
    }

    @GetMapping("/familiar/{idStudent}")
    public List<Familiar> getFamiliarByStudent(@PathVariable String idStudent) {
        return studentInputPort.getFamiliarByStudent(idStudent);
    }



}
