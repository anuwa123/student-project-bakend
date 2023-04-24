package com.ABC.Student.registration.controller;
import com.ABC.Student.registration.dto.StudentDto;
import com.ABC.Student.registration.dto.parameters.PaginationDto;
import com.ABC.Student.registration.dto.parameters.StudentSearchParameter;
import com.ABC.Student.registration.model.Student;
import com.ABC.Student.registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
  @Autowired
  StudentService studentService;
    @PostMapping("save")
    public @ResponseBody StudentDto saveStudent(@RequestBody StudentDto userInput) throws Exception {
        Student student = studentService.saveStudent(userInput);
        StudentDto studentdto = new StudentDto();
        studentdto.setStudentId(student.getStudent_id());
        studentdto.setName(student.getName());
        studentdto.setAddress(student.getAddress());
        studentdto.setContact(student.getContact());
        return studentdto;
    }
    @GetMapping("view")
    public @ResponseBody List<StudentDto> getAllStudent(){
        List<Student>studentList= studentService.getAllStudent();
        List<StudentDto> studentDtoList=new ArrayList<>();
        for (Student student:studentList){
            StudentDto studentDto=new StudentDto();
            studentDto.setStudentId(student.getStudent_id());
            studentDto.setName(student.getName());
            studentDto.setAddress(student.getAddress());
            studentDto.setContact(student.getContact());
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }
    @GetMapping("getById/{id}")
    public @ResponseBody StudentDto getStudentBYId(@PathVariable("id") String id){
        Student student=studentService.getStudentById(id);
        StudentDto studentDto= new StudentDto();
        studentDto.setStudentId(student.getStudent_id());
        studentDto.setName(student.getName());
        studentDto.setAddress(student.getAddress());
        studentDto.setContact(student.getContact());
        return studentDto;
    }
    @PutMapping("updateById/{id}")
    public @ResponseBody StudentDto updateStudentById(@PathVariable ("id") String id,@RequestBody StudentDto studentDto){
        Student student=studentService.updateStudentById(id,studentDto);
        studentDto.setStudentId(student.getStudent_id());
        studentDto.setName(student.getName());
        studentDto.setAddress(studentDto.getAddress());
        studentDto.setContact(studentDto.getContact());
        return studentDto;
    }
    @DeleteMapping("deleteById/{id}")
    public void deleteStudentById(@PathVariable ("id") String id){
        studentService.deleteStudentById(id);
    }

    @GetMapping("search")
    public List<StudentDto> searchStudents(@RequestParam ("keyword") String keyword){
        List<Student> studentList=studentService.searchStudent(keyword);
        List<StudentDto> studentDtoList=new ArrayList<>();
        for (Student student:studentList){
            StudentDto studentDto=new StudentDto();
            studentDto.setStudentId(student.getStudent_id());
            studentDto.setName(student.getName());
            studentDto.setAddress(student.getAddress());
            studentDto.setContact(student.getContact());
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }
    @GetMapping("get")
    public  ResponseEntity<PaginationDto<StudentDto>> searchStudent(StudentSearchParameter parameters){
        Page<Student> studentPagination = studentService.searchStudent(parameters);
        List<Student> sList = studentPagination.getContent();//convert DTO List
        List<StudentDto> studentDtoList=new ArrayList<>();
        for (Student student:sList){
            StudentDto studentDto=new StudentDto();
            studentDto.setStudentId(student.getStudent_id());
            studentDto.setName(student.getName());
            studentDto.setAddress(student.getAddress());
            studentDto.setContact(student.getContact());
            studentDtoList.add(studentDto);
        }
        return ResponseEntity.ok(new PaginationDto(studentDtoList,studentPagination));
    }
}
