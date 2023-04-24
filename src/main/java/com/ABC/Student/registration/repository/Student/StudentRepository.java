package com.ABC.Student.registration.repository.Student;
import com.ABC.Student.registration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student,String> ,IStudentRepository {
    @Query("SELECT p FROM Student p WHERE "+ " p.student_id LIKE CONCAT('%',:query,'%') ")
    List<Student> searchStudents (String query);
}
