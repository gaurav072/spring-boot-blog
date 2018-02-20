package com.startwithjava.simpleblog.repositories;
import com.startwithjava.simpleblog.entities.City;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao extends JpaDao<City, Long> {


}
