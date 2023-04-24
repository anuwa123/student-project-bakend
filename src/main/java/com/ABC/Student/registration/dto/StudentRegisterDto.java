package com.ABC.Student.registration.dto;

import com.ABC.Student.registration.model.Program;
import com.ABC.Student.registration.model.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentRegisterDto {
    private int id;
    private Student studentId;
    private Program programId;
    private String registerDate;
}
