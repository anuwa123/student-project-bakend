package com.ABC.Student.registration.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRegisterRequestDto {
    private int id;
    private String studentId;
    private String programId;
    private String registerDate;
}
