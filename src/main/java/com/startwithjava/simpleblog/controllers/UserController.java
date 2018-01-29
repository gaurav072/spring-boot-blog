package com.startwithjava.simpleblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	@GetMapping("/loginAdmin")
	public ModelAndView adminLogin(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/login");
		return mav;
	}
}