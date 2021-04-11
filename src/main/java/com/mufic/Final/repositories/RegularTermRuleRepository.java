package com.mufic.Final.repositories;

import com.mufic.Final.domain.PointKey;
import com.mufic.Final.domain.RegularTermRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface RegularTermRuleRepository extends JpaRepository<RegularTermRules, Long> {
}
