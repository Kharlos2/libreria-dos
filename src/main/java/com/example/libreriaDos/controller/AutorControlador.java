package com.example.libreriaDos.controller;

import com.example.libreriaDos.dto.autor.AutorCorrectoDto;
import com.example.libreriaDos.dto.autor.AutorDto;
import com.example.libreriaDos.dto.autor.AutorErrorDto;
import com.example.libreriaDos.entity.Autor;
import com.example.libreriaDos.service.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("autores")
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;

    @PostMapping("/save")
    public ResponseEntity<AutorDto> save(@RequestBody Autor datos) throws Exception {
        try {
            autorServicio.save(datos);
            AutorCorrectoDto mensaje = new AutorCorrectoDto();
            mensaje.setId(datos.getId());
            mensaje.setNombre(datos.getNombre());
            mensaje.setApellido(datos.getApellido());
            mensaje.setPseudonimo(datos.getPseudonimo());
            mensaje.setEmail(datos.getEmail());
            mensaje.setPais(datos.getPais());
            return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
        }catch (Exception error) {

            AutorErrorDto mensaje = new AutorErrorDto();
            mensaje.setMensaje(error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);

        }
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAll() throws Exception{
        return ResponseEntity.ok(autorServicio.getAll());
    }

}
