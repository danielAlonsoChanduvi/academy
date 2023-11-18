package com.daniverse.academy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Setter
@Getter
public class Familiar {
    private String id;
    private String fullname;
    private String gender;
    private String tipoFamiliar;
}
