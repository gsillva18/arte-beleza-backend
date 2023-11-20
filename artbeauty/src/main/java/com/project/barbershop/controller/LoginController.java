package com.project.barbershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/art-beauty")
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    public void logOff(){

    }

}
