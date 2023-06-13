package com.example.libreriaDos.service;

import com.example.libreriaDos.dto.autor.AutorCorrectoDto;
import com.example.libreriaDos.entity.Autor;
import com.example.libreriaDos.mappers.AuthorMapper;
import com.example.libreriaDos.repository.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AutorServicio implements ServiciosBase<AutorCorrectoDto,Autor>{
    @Autowired
    protected AutorRepositorio autorRepositorio;

    @Autowired
    public AuthorMapper authorMapper;


    @Override
    public AutorCorrectoDto save(Autor datos) throws Exception {
        try {
            if (!Verificacion.verficarPseudonimoONombreApellido(datos.getNombre(),datos.getApellido(), datos.getPseudonimo())){
                throw new  Exception("El autor debe tener nombre y apellido o pseudonimo");
            } else if (Verificacion.verificarCorreo(datos.getEmail())) {
                throw new Exception("El correo no cumple con la estructura de un correo normal");
            }else if (autorRepositorio.existsByEmail(datos.getEmail())){
                throw new Exception("Este correo ya esta registrado");
            }else if(autorRepositorio.existsByPseudonimo(datos.getPseudonimo())&&!datos.getPseudonimo().isEmpty()){
                throw new Exception("Este pseudonimo ya esta registrado");
            }else {
                return authorMapper.toAutorDto(autorRepositorio.save(datos));
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public List<AutorCorrectoDto> getAll() throws Exception {
        try {
            return authorMapper.toAutoresDto(autorRepositorio.findAll());

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
