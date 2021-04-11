package com.mufic.Final.repositories;

import com.mufic.Final.domain.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findByName(String privilege);
}
