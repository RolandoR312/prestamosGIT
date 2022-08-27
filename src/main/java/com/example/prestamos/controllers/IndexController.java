package com.example.prestamos.controllers;


import com.example.prestamos.entities.User;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("index")
public class IndexController {

    //Se coloca una propiedad del Tipo UserSevice, para poder trabajar con la logica de negocio de la aplicacion
    private UserService userService;
    //Por medio de la inyección de dependencias, se inicializa el sevicio.
    public IndexController(UserService service){
        this.userService = service;
    }

    @RequestMapping("getusuarios")
    public ArrayList<User> getUsuarios(){
        return this.userService.selectAll();
    }

    @RequestMapping("getsaludo")
    public String saludar(){
        return "Saludo developes";
    }

    @PostMapping("create")
    public Response createuser(@RequestBody User request){
         return this.userService.createUser(request);
    }

}
