package com.ABC.Student.registration.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name="Student")
@Getter
@Setter
public class Student {
    @Id
    private String student_id;
    private String name;
    private String address;
    private String contact;

}
