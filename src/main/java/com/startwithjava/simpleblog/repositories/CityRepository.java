package com.startwithjava.simpleblog.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.startwithjava.simpleblog.entities.City;
public interface CityRepository extends JpaRepository<City,Long>, JpaSpecificationExecutor {
}
