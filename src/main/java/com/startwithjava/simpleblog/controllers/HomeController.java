package com.startwithjava.simpleblog.controllers;
import com.startwithjava.simpleblog.entities.City;
import com.startwithjava.simpleblog.repositories.CityRepository;
import com.startwithjava.simpleblog.repositories.CitySpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CityRepository cityRepository;
	@GetMapping("/")
    public String root() {
        List<City> listCities = cityRepository.findAll( CitySpecifications.hasCountry());
        System.out.println(listCities);
	    return "index";
    }

}
