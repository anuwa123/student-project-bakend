package com.ABC.Student.registration.dto.parameters;

public class StudentSearchParameter extends SearchParameter {

    public static StudentSearchParameter init(int page,int size){
        StudentSearchParameter studentSearchParameter=new StudentSearchParameter();
        studentSearchParameter.setPage(page);
        studentSearchParameter.setSize(size);
        return studentSearchParameter;
    }

}
