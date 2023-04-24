package com.ABC.Student.registration.repository.Program;
import com.ABC.Student.registration.model.Program;
import com.ABC.Student.registration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program,String>,IProgramRepository {
    @Query("SELECT p FROM Program p WHERE "+ " p.program_id LIKE CONCAT('%',:query,'%') ")
    List<Program> searchPrograms (String query);
}
