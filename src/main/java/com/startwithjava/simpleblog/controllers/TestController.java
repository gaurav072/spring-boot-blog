package com.startwithjava.simpleblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("detail")
    public String detail(){
        return "detail";
    }
}
