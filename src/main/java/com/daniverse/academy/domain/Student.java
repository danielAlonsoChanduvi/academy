package com.daniverse.academy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
public class Student {
    private String id;
    private String fullname;
    private String gender;
    private LocalDate birthdate;
    private String documentType;
    private String documentNumber;
    private List<Familiar> familiares;
}
