package com.mufic.Final.repositories;

import com.mufic.Final.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByName(String name);
}
