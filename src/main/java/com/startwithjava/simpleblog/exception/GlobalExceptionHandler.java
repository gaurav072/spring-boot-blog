package com.startwithjava.simpleblog.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleMessageNotFound(HttpServletRequest req, Exception ex) {
		System.out.println("=============handleMessageNotFound========");
		ModelAndView mav = new ModelAndView();
	    System.out.println(ex);
	    mav.addObject("exception", ex);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("error");
	    return mav;
	}
}
