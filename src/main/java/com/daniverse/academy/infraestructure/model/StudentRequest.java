package com.daniverse.academy.infraestructure.model;

import com.daniverse.academy.domain.Familiar;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
public class StudentRequest {
    @NotBlank(message = "Id is mandatory")
    private String id;
    @NotBlank(message = "Fullname is mandatory")
    private String fullname;
    @NotBlank(message = "Gender is mandatory")
    private String gender;
    @NotBlank(message = "Birthdate is mandatory")
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((?:19|20)[0-9][0-9])+$", message = "Date is invalid")
    private String birthdate;
    @NotBlank(message = "Document type is mandatory")
    private String documentType;
    @NotBlank(message = "Document number is mandatory")
    private String documentNumber;
    private final List<Familiar> familiares = new ArrayList<>();
}
