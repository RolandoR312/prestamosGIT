package com.example.prestamos.services;

import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.repository.ITipoDocumentoRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class TipoDocumentoService {

    private ITipoDocumentoRepository repository;

    public TipoDocumentoService(ITipoDocumentoRepository rep){
        this.repository = rep;
    }

    public ArrayList<TipoDocumento> selectAll(){
        return (ArrayList<TipoDocumento>) this.repository.findAll();
    }

    ///Metodo que permite registrar un documento
    public Response createDocumento(TipoDocumento data){

        //Debo validar si el documento ya existe
        ArrayList<TipoDocumento> documentos = this.repository.findByNombre(data.getNombre());
        if(documentos != null && documentos.size() > 0){
            Response response = new Response();
            response.setCode(500);
            response.setMessage("Este tipo de documento ya existe");
            return response;
        }

        this.repository.save(data);
        Response response = new Response();
        response.setCode(200);
        response.setMessage("Documento registrado exitosamente");
        return response;
    }

}
