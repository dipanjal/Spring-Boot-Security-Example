package com.example.oauth.test.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "<h1>What A World!!</h1>";
    }

    @RequestMapping("/user/home")
    public String indexUser(){
        return "user/home";
    }

    @RequestMapping("/admin/home")
    public String indexAdmin(){
        return "admin/home";
    }
}
