package com.mufic.Final.repositories;

import com.mufic.Final.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin
public interface StudentHasCourseInTermRepository extends JpaRepository<StudentHasCourseInTerm, StudentHasCourseInTermID> {

//    @RestResource(path = "getTermForStudent")
    Optional<StudentHasCourseInTerm> findByStudent_Id(Long id);

//    @RestResource(path = "getStudentsForTerm")
    Optional<StudentHasCourseInTerm> findByCourseInTerm(String code);


}
