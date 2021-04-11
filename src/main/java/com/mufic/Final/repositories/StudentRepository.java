package com.mufic.Final.repositories;

import com.mufic.Final.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface StudentRepository extends JpaRepository<Student, Long> {

    @RestResource(path = "username")
    Student findByUserUsername(String username);
}
