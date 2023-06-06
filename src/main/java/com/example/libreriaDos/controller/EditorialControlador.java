package com.example.libreriaDos.controller;

import com.example.libreriaDos.dto.editorial.EditorialCorrectoDto;
import com.example.libreriaDos.dto.editorial.EditorialDto;
import com.example.libreriaDos.dto.editorial.EditorialErrorDto;
import com.example.libreriaDos.entity.Editorial;
import com.example.libreriaDos.service.EditorialServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("editoriales")
public class EditorialControlador {

    @Autowired
    private EditorialServicio editorialServicio;

    @PostMapping("/save")
    public ResponseEntity<EditorialDto> save(@RequestBody Editorial datos) throws Exception{
        try {
            editorialServicio.save(datos);
            EditorialCorrectoDto mensajeCorrecto = new EditorialCorrectoDto();
            mensajeCorrecto.setId(datos.getId());
            mensajeCorrecto.setNombre(datos.getNombre());
            mensajeCorrecto.setDescripcion(datos.getDescripcion());
            return ResponseEntity.status(HttpStatus.CREATED).body(mensajeCorrecto);
        }catch (Exception error){

            EditorialErrorDto mensaje = new EditorialErrorDto();
            mensaje.setMensaje(error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
        }
    }
    @GetMapping
    public ResponseEntity<List<Editorial>> getAll() throws Exception {
        return ResponseEntity.ok(editorialServicio.getAll());
    }


}
