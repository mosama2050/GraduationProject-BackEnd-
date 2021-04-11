package com.mufic.Final.repositories;

import com.mufic.Final.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
//@RepositoryRestResource()
public interface CityRepository extends JpaRepository<City, Long> {
}
