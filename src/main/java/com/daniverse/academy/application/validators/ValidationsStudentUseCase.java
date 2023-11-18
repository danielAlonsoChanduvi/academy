package com.daniverse.academy.application.validators;

import com.daniverse.academy.domain.Familiar;
import com.daniverse.academy.infraestructure.exceptionhandler.BussinesRequestException;
import com.daniverse.academy.infraestructure.model.StudentRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Objects;

@Component
public class ValidationsStudentUseCase {


    @Value("#{'${values-application.tipofamiliares}'.split(',')}")
    private List<String> allowedFamiliares;

    public void validateQuanitiyFamiliaresOfStudent(StudentRequest studentRequest) {
        if (Objects.isNull(studentRequest.getFamiliares()) || studentRequest.getFamiliares().size() < 2) {
            throw new BussinesRequestException("BS001","El estudiante no tiene los familiares mínimos");
        }
    }

    public void validateTipoFamiliares(StudentRequest studentRequest) {

        List<Familiar> familiares = studentRequest.getFamiliares();



        familiares.stream()
                .forEach(familiar -> {
                    if (!allowedFamiliares.contains(familiar.getTipoFamiliar())) {
                        throw new BussinesRequestException("BS002",
                                "El tipo de famliar no es admitido: " + familiar.getFullname());
                    }
                });
    }


    public void validateTipoFamiliar(Familiar familiar) {

        if (!allowedFamiliares.contains(familiar.getTipoFamiliar())) {
            throw new BussinesRequestException("BS003","El tipo de famliar no es admitido");
        }
    }


}
