package com.startwithjava.simpleblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
    @RequestMapping("/posts")
    public String index()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("posts/list");
        return null;
    }
}
