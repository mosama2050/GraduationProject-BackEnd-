package com.mufic.Final.repositories;

import com.mufic.Final.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ProgramRepository extends JpaRepository<Program, Long> {
}
