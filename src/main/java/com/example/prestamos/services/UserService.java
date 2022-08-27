package com.example.prestamos.services;

import com.example.prestamos.entities.User;
import com.example.prestamos.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository rep){
        this.userRepository = rep;
    }

    ///Metodo que me permite obtener todos los usuarios de la base de datos.
    public ArrayList<User> selectAll(){
        return (ArrayList<User>) this.userRepository.findAll();
    }

    public Response createUser(User data){
        Response response = new Response();
        this.userRepository.save(data);
        response.setCode(200);
        response.setMessage("Usuario registrado exitosamente");
        return response;
    }


}
