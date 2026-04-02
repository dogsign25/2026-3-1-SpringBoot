package com.dongyang.basicExample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/hi")
    public String hello(){
        return "greetings";
    }
}
