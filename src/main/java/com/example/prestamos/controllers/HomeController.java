package com.example.prestamos.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("inicio")
    public String inicio(){
        return "home/inicio";
    }
    //Esta es una prueba para validar el git push
}
