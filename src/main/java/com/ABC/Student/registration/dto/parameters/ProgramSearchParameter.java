package com.ABC.Student.registration.dto.parameters;

public class ProgramSearchParameter extends SearchParameter{
    public static ProgramSearchParameter init(int page,int size){
        ProgramSearchParameter programSearchParameter=new ProgramSearchParameter();
        programSearchParameter.setPage(page);
        programSearchParameter.setSize(size);
        return programSearchParameter;
    }
}
