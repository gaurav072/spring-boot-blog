package com.startwithjava.simpleblog.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TestController {
	@RequestMapping("/test")
    public String detail() throws SQLException{
		if(true) {
			throw new SQLException("Test");
		}
        return "index";
    }
}
