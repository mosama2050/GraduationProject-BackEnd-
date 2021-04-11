package com.mufic.Final.repositories;

import com.mufic.Final.domain.Labs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
public interface LabRepository extends JpaRepository<Labs, Long> {
}
