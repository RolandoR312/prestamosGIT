package com.example.prestamos.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping("login")
    public String login(){
        return "login/login";
    }

    @GetMapping("registro")
    public String registro(){
        return "login/registro";
    }

}
