package com.startwithjava.simpleblog.rest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FirstRestController {
	@RequestMapping("/rest")
	public void test() {
		System.out.println("Rest invoked");
	}
	@GetMapping("/rest/chk")
	public ModelAndView test2() {
		System.out.println("Rest invoked");	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("frontend/test");
		ModelMap map = new ModelMap();
		map.put("test", "100");
		map.put("test1", "200");
	    mav.addAllObjects(map);
		return mav;
	}
	
}
