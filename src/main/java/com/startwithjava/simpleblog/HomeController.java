package com.startwithjava.simpleblog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.startwithjava.simpleblog.entities.City;
import com.startwithjava.simpleblog.repositories.CityRepository;

@Controller
public class HomeController {
	@Autowired
	CityRepository cityRepository;
	@RequestMapping(value="/test")
	public String test() {
		City city = cityRepository.findByNameAndCountryAllIgnoringCase("Delhi", "India");
		if(city!=null)
		System.out.println(city.getState());
		return "test";
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login() {
		return "home";
	}
	@RequestMapping(value="/403",method=RequestMethod.GET)
	public String accessDenied() {
		return "403";
	}
}
