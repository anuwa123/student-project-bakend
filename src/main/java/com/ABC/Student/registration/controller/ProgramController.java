package com.ABC.Student.registration.controller;
import com.ABC.Student.registration.dto.ProgramDto;
import com.ABC.Student.registration.dto.parameters.PaginationDto;
import com.ABC.Student.registration.dto.parameters.ProgramSearchParameter;
import com.ABC.Student.registration.model.Program;
import com.ABC.Student.registration.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/program/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProgramController {
    @Autowired
    ProgramService programService;
    @PostMapping("save")
    public @ResponseBody ProgramDto saveProgram(@RequestBody ProgramDto userInput) throws Exception{
        Program program=programService.saveProgram(userInput);
        ProgramDto programDto =new ProgramDto();
        programDto.setProgramId(program.getProgram_id());
        programDto.setName(program.getName());
        programDto.setDuration(program.getDuration());
        programDto.setCost(program.getCost());
        return programDto;
    }
    @GetMapping("view")
    public @ResponseBody List<ProgramDto> getAllProgram(){
        List<Program> programList=programService.getAllProgram();
        List<ProgramDto> programDtoList=new ArrayList<>();
        for(Program program:programList){
            ProgramDto programDto =new ProgramDto();
            programDto.setProgramId(program.getProgram_id());
            programDto.setName(program.getName());
            programDto.setDuration(program.getDuration());
            programDto.setCost(program.getCost());
            programDtoList.add(programDto);
        }
        return programDtoList;
    }
    @GetMapping("getById/{id}")
    public @ResponseBody ProgramDto getProgramById(@PathVariable("id") String id){
        Program program =programService.getProgramById(id);
        ProgramDto programDto =new ProgramDto();
        programDto.setProgramId(program.getProgram_id());
        programDto.setName(program.getName());
        programDto.setDuration(program.getDuration());
        programDto.setCost(program.getCost());
        return programDto;
    }
    @PutMapping("updateById/{id}")
    public @ResponseBody ProgramDto updateProgramById(@PathVariable("id") String id,@RequestBody ProgramDto programDto){
        Program program =programService.updateProgramById(id,programDto);
        programDto.setProgramId(program.getProgram_id());
        programDto.setName(program.getName());
        programDto.setDuration(program.getDuration());
        programDto.setCost(program.getCost());
        return programDto;
    }
    @DeleteMapping("deleteById/{id}")
    public void deleteProgramById(@PathVariable("id") String id){
        programService.deleteProgramById(id);
    }

    @GetMapping("search")
    public List<ProgramDto> searchPrograms(@RequestParam ("keyword") String keyword){
        List<Program> programList=programService.searchProgram(keyword);
        List<ProgramDto> programDtoList=new ArrayList<>();
        for (Program program:programList){
            ProgramDto programDto=new ProgramDto();
            programDto.setProgramId(program.getProgram_id());
            programDto.setName(program.getName());
            programDto.setDuration(program.getDuration());
            programDto.setCost(program.getCost());
            programDtoList.add(programDto);
        }
        return programDtoList;
    }
    @GetMapping("get")
    public ResponseEntity<PaginationDto<ProgramDto>> searchStudent(ProgramSearchParameter parameters){
        Page<Program> programPagination = programService.searchProgram(parameters);
        List<Program> pList = programPagination.getContent();//convert DTO List
        List<ProgramDto> programDtoList=new ArrayList<>();
        for (Program program:pList){
            ProgramDto programDto=new ProgramDto();
            programDto.setProgramId(program.getProgram_id());
            programDto.setName(program.getName());
            programDto.setDuration(program.getDuration());
            programDto.setCost(program.getCost());
            programDtoList.add(programDto);
        }
        return ResponseEntity.ok(new PaginationDto(programDtoList,programPagination));
    }
}
