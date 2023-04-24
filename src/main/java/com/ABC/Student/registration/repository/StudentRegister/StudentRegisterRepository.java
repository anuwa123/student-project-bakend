package com.ABC.Student.registration.repository.StudentRegister;

import com.ABC.Student.registration.model.StudentRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRegisterRepository extends JpaRepository<StudentRegister,String> {
}
