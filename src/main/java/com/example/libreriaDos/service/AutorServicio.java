package com.example.libreriaDos.service;

import com.example.libreriaDos.entity.Autor;
import com.example.libreriaDos.repository.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutorServicio implements ServiciosBase<Autor>{
    @Autowired
    protected AutorRepositorio autorRepositorio;


    @Override
    public Autor save(Autor datos) throws Exception {

        return autorRepositorio.save(datos);

    }
}
