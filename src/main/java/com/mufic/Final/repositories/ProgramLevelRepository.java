package com.mufic.Final.repositories;

import com.mufic.Final.domain.ProgramLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ProgramLevelRepository extends JpaRepository<ProgramLevel, Long> {
}
