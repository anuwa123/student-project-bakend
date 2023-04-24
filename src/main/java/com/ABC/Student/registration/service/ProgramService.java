package com.ABC.Student.registration.service;
import com.ABC.Student.registration.dto.ProgramDto;
import com.ABC.Student.registration.dto.parameters.ProgramSearchParameter;
import com.ABC.Student.registration.dto.parameters.StudentSearchParameter;
import com.ABC.Student.registration.model.Program;
import com.ABC.Student.registration.model.Student;
import com.ABC.Student.registration.repository.Program.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProgramService{
    @Autowired
    ProgramRepository programrepository;

    public Program saveProgram(ProgramDto request) throws Exception{
        Program program=new Program();
        Optional<Program> stud=programrepository.findById(request.getProgramId());
        if (!stud.isEmpty()){
            throw new RuntimeException("Already registered Program id");}
        program.setProgram_id(request.getProgramId());
        program.setName(request.getName());
        program.setDuration(request.getDuration());
        program.setCost(request.getCost());
        Program program_repo=programrepository.save(program);
        return program_repo;
    }
    public List<Program> getAllProgram(){
        return programrepository.findAll();
    }
    public Program getProgramById(String id){
        return programrepository.findById(id).get();
    }
    public Program updateProgramById(String id,ProgramDto programDto){
        Program program =programrepository.findById(id).get();
        program.setName(programDto.getName());
        program.setDuration(programDto.getDuration());
        program.setCost(programDto.getCost());
        return programrepository.save(program);
    }
    public void deleteProgramById(String id){
         programrepository.deleteById(id);
    }
    public List<Program> searchProgram(String keyword){
        return programrepository.searchPrograms(keyword);
    }
    public Page<Program> searchProgram(ProgramSearchParameter parameters){
        return programrepository.searchProgram(parameters);
    }
}
