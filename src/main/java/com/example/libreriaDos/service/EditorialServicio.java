package com.example.libreriaDos.service;

import com.example.libreriaDos.entity.Editorial;
import com.example.libreriaDos.repository.EditorialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialServicio implements ServiciosBase<Editorial>{


    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Override
    public Editorial save(Editorial datos) throws Exception {
        try {
            if (editorialRepositorio.existsByNombre(datos.getNombre())){
                throw new Exception("Ya existe este nombre");
            } else if (datos.getNombre().length()<2 || datos.getNombre().length()>30) {
                throw new Exception("Cantidad de caracteres incorrecta en nombre deben ser entre 2 y 30 caracteres");
            } else if (datos.getDescripcion().length()>300) {
                throw new Exception("Excedio el limite de 300 caracteres en la descripcion");
            } else{
                return editorialRepositorio.save(datos);
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public List<Editorial> getAll() throws Exception {
        return editorialRepositorio.findAll();
    }
}
