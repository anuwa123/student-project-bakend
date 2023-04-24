package com.ABC.Student.registration.repository.Program;
import com.ABC.Student.registration.dto.parameters.ProgramSearchParameter;
import com.ABC.Student.registration.model.Program;
import org.springframework.data.domain.Page;

public interface IProgramRepository {
    Page<Program> searchProgram(ProgramSearchParameter parameter);
}
