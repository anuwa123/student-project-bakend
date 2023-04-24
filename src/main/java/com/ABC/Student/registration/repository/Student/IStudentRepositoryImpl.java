package com.ABC.Student.registration.repository.Student;
import com.ABC.Student.registration.dto.parameters.StudentSearchParameter;
import com.ABC.Student.registration.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
@Service
public class IStudentRepositoryImpl implements IStudentRepository {
    @Autowired
    EntityManager entityManager;

    public Page<Student> searchStudent(StudentSearchParameter parameters) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Student.class);
        var root =query.from(Student.class);
        query.select(root);
        PageRequest pageRequest=PageRequest.of(parameters.getPage(), parameters.getSize());
        var total=resultCount(parameters);
        List<Student> studentList=entityManager.createQuery(query)
                .setFirstResult(parameters.getPage()* parameters.getSize())
                .setMaxResults(parameters.getSize())
                .getResultList();

        return new PageImpl<>(studentList,pageRequest,total) ;
    }
    public Long resultCount(StudentSearchParameter parameters){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Long.class);
        var root =query.from(Student.class);
        query.select(criteriaBuilder.count(root));

        return entityManager.createQuery(query).getSingleResult();
}

}

