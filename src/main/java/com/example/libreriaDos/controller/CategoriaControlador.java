package com.example.libreriaDos.controller;

import com.example.libreriaDos.dto.categoria.CategoriaCorrectoDto;
import com.example.libreriaDos.dto.categoria.CategoriaDto;
import com.example.libreriaDos.dto.categoria.CategoriaErrorDto;
import com.example.libreriaDos.entity.Categoria;
import com.example.libreriaDos.service.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio categoriaServicio;
    @PostMapping("/save")
    public ResponseEntity<CategoriaDto> save(@RequestBody Categoria datos) throws Exception {
        try {
            categoriaServicio.save(datos);
            CategoriaCorrectoDto mensaje = new CategoriaCorrectoDto();
            mensaje.setId(datos.getId());
            mensaje.setNombre(datos.getNombre());
            mensaje.setDescripcion(datos.getDescripcion());
            return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
        }catch (Exception error){
            CategoriaErrorDto mensaje = new CategoriaErrorDto();
            mensaje.setMensaje(error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
        }
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() throws Exception{
        return ResponseEntity.ok(categoriaServicio.getAll());
    }

}
