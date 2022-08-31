package com.example.prestamos.services;

import com.example.prestamos.entities.User;
import com.example.prestamos.repository.IUserRepository;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Optional;

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

    public User selectById(int Id){
        Optional<User> existe = this.userRepository.findById(Id);
        if(existe.isPresent()){
            return existe.get();
        }
        else {
            return null;
        }
    }

    public Response deleteUserById(int Id){
        Response response = new Response();
        try {
            this.userRepository.deleteById(Id);
            response.setCode(200);
            response.setMessage("Usuario eliminado exitosamente");
            return response;
        }
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error " + ex.getMessage());
            return response;
        }
    }

    public Response updateUser(User data){
        Response response = new Response();

        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error, el Id del usuario no es válido.");
            return response;
        }

        //Validamos si el usuario que desea actualizar existe.
        User exists = selectById(data.getId());
        if(exists == null){
            response.setCode(500);
            response.setMessage("Error, el usuario no existe en la base de datos.");
            return response;
        }

        if(data.getCorreoElectronico().equals(null) || data.getCorreoElectronico().equals("")){
            response.setCode(500);
            response.setMessage("Error, el correo electronico no es válido.");
            return response;
        }

        if(!isValidEmailAddress(data.getCorreoElectronico())){
            response.setCode(500);
            response.setMessage("Error, el correo electronico no tiene el formato adecuado.");
            return response;
        }

        exists.setCorreoElectronico(data.getCorreoElectronico());
        exists.setEdad(data.getEdad());

        this.userRepository.save(exists);
        response.setCode(200);
        response.setMessage("Usuario modificado exitosamente");
        return  response;
    }

    public boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
