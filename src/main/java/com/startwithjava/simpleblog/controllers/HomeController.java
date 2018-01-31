package com.startwithjava.simpleblog.controllers;
import com.startwithjava.simpleblog.entities.City;
import com.startwithjava.simpleblog.repositories.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	@GetMapping("/")
    public String root() {
	    return "index";
    }

}
