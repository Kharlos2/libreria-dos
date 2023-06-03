package com.example.libreriaDos.controller;

import com.example.libreriaDos.entity.Autor;
import com.example.libreriaDos.service.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("autores")
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;

    @PostMapping("/save")
    public ResponseEntity<Autor> save(@RequestBody Autor datos) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(autorServicio.save(datos));
    }
}
