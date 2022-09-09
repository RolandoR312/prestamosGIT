package com.example.prestamos.controllers;


import com.example.prestamos.entities.User;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("login")
public class LoginController {

    private UserService service;

    public LoginController(UserService service){
        this.service = service ;
    }

    @GetMapping("login")
    public String login(){
        return "login/login";
    }

    @GetMapping("registro")
    public String registro(){
        return "login/registro";
    }

    @PostMapping("postlogin")
    public RedirectView postlogin(User data){
        Response response = this.service.loginUser(data);
        if(response.getCode() == 200){
            return new RedirectView("/inicio");
        }
        else{
            return new RedirectView("/login/error");
        }
    }

    @GetMapping("error")
    public String error(){
        return "login/error";
    }

}
