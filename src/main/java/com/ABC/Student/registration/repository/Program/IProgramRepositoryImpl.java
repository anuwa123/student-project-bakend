package com.ABC.Student.registration.repository.Program;
import com.ABC.Student.registration.dto.parameters.ProgramSearchParameter;
import com.ABC.Student.registration.model.Program;
import com.ABC.Student.registration.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class IProgramRepositoryImpl implements IProgramRepository{
    @Autowired
    EntityManager entityManager;

    public Page<Program> searchProgram(ProgramSearchParameter parameters) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Program.class);
        var root =query.from(Program.class);
        query.select(root);
        PageRequest pageRequest=PageRequest.of(parameters.getPage(), parameters.getSize());
        var total=resultCount(parameters);
        List<Program> programList=entityManager.createQuery(query)
                .setFirstResult(parameters.getPage()* parameters.getSize())
                .setMaxResults(parameters.getSize())
                .getResultList();

        return new PageImpl<>(programList,pageRequest,total) ;
    }
    public Long resultCount(ProgramSearchParameter parameters){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Long.class);
        var root =query.from(Program.class);
        query.select(criteriaBuilder.count(root));

        return entityManager.createQuery(query).getSingleResult();
    }


}
