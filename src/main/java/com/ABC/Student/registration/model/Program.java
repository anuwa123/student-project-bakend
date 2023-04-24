package com.ABC.Student.registration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name="Program")
@Getter
@Setter
public class Program {
    @Id
    private String program_id;
    private String name ;
    private String duration ;
    private double cost;
}
