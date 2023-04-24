package com.ABC.Student.registration.controller;
import com.ABC.Student.registration.dto.StudentRegisterDto;
import com.ABC.Student.registration.dto.StudentRegisterRequestDto;
import com.ABC.Student.registration.model.Program;
import com.ABC.Student.registration.model.Student;
import com.ABC.Student.registration.model.StudentRegister;
import com.ABC.Student.registration.service.StudentRegisterService;
import com.ABC.Student.registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignStudent")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentRegisterController {
    @Autowired
    StudentRegisterService studentRegisterService;
    @Autowired
    StudentService studentService;
    @PostMapping
    public @ResponseBody StudentRegisterDto assignStudentById(@RequestBody StudentRegisterRequestDto request){
        StudentRegister studentRegister=studentRegisterService.assignStudentById(request);
        Student student =new Student();
        student.setStudent_id(studentRegister.getStudent().getStudent_id());
//        student.setName(studentRegister.getStudent().getName());
        Program program =new Program();
        program.setProgram_id(studentRegister.getProgram().getProgram_id());
        program.setProgram_id(studentRegister.getProgram().getProgram_id());
        StudentRegisterDto studentRegisterDto= new StudentRegisterDto();
        studentRegisterDto.setStudentId(student);
        studentRegisterDto.setProgramId(program);
        studentRegisterDto.setRegisterDate(String.valueOf(studentRegister.getRegister_date()));
        return studentRegisterDto;
    }
}
