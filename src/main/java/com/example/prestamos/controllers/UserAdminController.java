package com.example.prestamos.controllers;

import com.example.prestamos.entities.User;
import com.example.prestamos.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("admin")
public class UserAdminController {

    private UserService service;

    public UserAdminController(UserService service){
        this.service = service;
    }


    @GetMapping("usuarios")
    public String usuariosregistrados(Model usuarios){
        ArrayList<User> usersDB = this.service.selectAll();
        usuarios.addAttribute("usuarios",usersDB);
        return "/useradmin/usuariosregistrados";
    }

}
