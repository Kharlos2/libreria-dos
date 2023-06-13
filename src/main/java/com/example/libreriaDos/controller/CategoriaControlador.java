package com.example.libreriaDos.controller;

import com.example.libreriaDos.dto.categoria.CategoriaDto;
import com.example.libreriaDos.dto.categoria.CategoriaErrorDto;
import com.example.libreriaDos.entity.Categoria;
import com.example.libreriaDos.service.CategoriaServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio categoriaServicio;
    @Operation(summary = "Guarda una categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria guardada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Categoria.class)) }),
            @ApiResponse(responseCode = "400", description = "Categoria no valida",
                    content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<CategoriaDto> save(@RequestBody Categoria datos) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaServicio.save(datos));
        }catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CategoriaErrorDto(error.getMessage()));
        }
    }
    @Operation(summary = "Busca todas las categorias")
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> getAll() throws Exception{
        try {
            return ResponseEntity.ok(new ArrayList<>(categoriaServicio.getAll()));
        }catch (Exception error){
            List<CategoriaDto> categoriaDto = new ArrayList<>();
            categoriaDto.add(new CategoriaErrorDto(error.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(categoriaDto);
        }
    }

}
