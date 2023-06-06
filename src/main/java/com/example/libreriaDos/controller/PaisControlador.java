package com.example.libreriaDos.controller;

import com.example.libreriaDos.entity.Pais;
import com.example.libreriaDos.service.PaisServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paises")
public class PaisControlador {

    @Autowired
    private PaisServicio paisServicio;

    @PostMapping("/save")
    public ResponseEntity<Pais> save(@RequestBody Pais datos) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(paisServicio.save(datos));
    }

    @GetMapping
    public ResponseEntity<List<Pais>> getAll() throws Exception{
        return ResponseEntity.ok(paisServicio.getAll());
    }

}
