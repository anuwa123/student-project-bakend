package com.ABC.Student.registration.repository.Student;

import com.ABC.Student.registration.dto.parameters.StudentSearchParameter;
import com.ABC.Student.registration.model.Student;
import org.springframework.data.domain.Page;

public interface IStudentRepository  {
    Page<Student> searchStudent(StudentSearchParameter parameter);
}
