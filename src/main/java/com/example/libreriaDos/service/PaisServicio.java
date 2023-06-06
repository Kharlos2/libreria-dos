package com.example.libreriaDos.service;

import com.example.libreriaDos.entity.Pais;
import com.example.libreriaDos.repository.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServicio{

    @Autowired
    private PaisRepositorio paisRepositorio;


    public Pais save(Pais datos) throws Exception {
        return paisRepositorio.save(datos);
    }

    public List<Pais> getAll() throws Exception {
        return paisRepositorio.findAll();
    }
}
