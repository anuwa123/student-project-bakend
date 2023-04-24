package com.ABC.Student.registration.service;
import com.ABC.Student.registration.dto.StudentDto;
import com.ABC.Student.registration.dto.parameters.StudentSearchParameter;
import com.ABC.Student.registration.model.Student;
import com.ABC.Student.registration.repository.Student.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class StudentService {
    @Autowired
    StudentRepository studentrepository;
    public Student saveStudent(StudentDto request) throws Exception {
        log.info("savestudent studentrequest={}",request.getName());
        Optional <Student> stud=studentrepository.findById(request.getStudentId());
        if (!stud.isEmpty()){
            throw new RuntimeException("Already registered Student id");}
            Student student =new Student();
            student.setStudent_id(request.getStudentId());
            student.setName(request.getName());
            student.setAddress(request.getAddress());
            student.setContact(request.getContact());
            Student student_repo=studentrepository.save(student);
            return student_repo;
    }
    public List<Student> getAllStudent(){
        return studentrepository.findAll();
    }
    public Student getStudentById(String id){
        return studentrepository.findById(id).get();
    }
    public Student updateStudentById(String id,StudentDto studentDto){
        Student student = studentrepository.findById(id).get();
        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());
        student.setContact(studentDto.getContact());
        return studentrepository.save(student);
    }
    public void deleteStudentById(String id){
        studentrepository.deleteById(id);
    }
    public List<Student> searchStudent(String keyword){
        return studentrepository.searchStudents(keyword);
    }
    public Page<Student> searchStudent(StudentSearchParameter parameters){
        return studentrepository.searchStudent(parameters);
    }
}
