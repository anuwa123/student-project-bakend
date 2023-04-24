package com.ABC.Student.registration.service;
import com.ABC.Student.registration.dto.StudentRegisterRequestDto;
import com.ABC.Student.registration.model.Program;
import com.ABC.Student.registration.model.Student;
import com.ABC.Student.registration.model.StudentRegister;
import com.ABC.Student.registration.repository.Program.ProgramRepository;
import com.ABC.Student.registration.repository.Student.StudentRepository;
import com.ABC.Student.registration.repository.StudentRegister.StudentRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
public class StudentRegisterService {
    @Autowired
    StudentRegisterRepository studentRegisterRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProgramRepository programRepository;
    public StudentRegister assignStudentById(StudentRegisterRequestDto registerDto){
        Student student= studentRepository.findById(registerDto.getStudentId()).get();
        Program program=programRepository.findById(registerDto.getProgramId()).get();
        StudentRegister studentRegister =new StudentRegister();
        studentRegister.setStudent(student);
        studentRegister.setProgram(program);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        studentRegister.setRegister_date(LocalDate.parse(registerDto.getRegisterDate(),formatter));
        return studentRegisterRepository.save(studentRegister);
    }
}
