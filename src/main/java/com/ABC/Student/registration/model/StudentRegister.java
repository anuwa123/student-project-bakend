package com.ABC.Student.registration.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name ="StudentRegister")
@Getter
@Setter
public class StudentRegister{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name ="student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name ="program_id")
    private Program program;
    private LocalDate register_date;
}
