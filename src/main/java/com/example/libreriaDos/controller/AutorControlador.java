package com.example.libreriaDos.controller;
import com.example.libreriaDos.dto.autor.AutorDto;
import com.example.libreriaDos.dto.autor.AutorErrorDto;
import com.example.libreriaDos.entity.Autor;
import com.example.libreriaDos.service.AutorServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("autores")
@Tag(name="Servicio Autores",description = "Servicios que ofrecen CRUD en la entidad autor")
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;

    @Operation(summary = "Guarda un autor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Autor guardado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Autor.class)) }),
            @ApiResponse(responseCode = "400", description = "Autor no valido",
                    content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<AutorDto> save(@RequestBody Autor datos) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(autorServicio.save(datos));
        }catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AutorErrorDto(error.getMessage()));
        }
    }
    @Operation(summary = "Busca todos los autores")
    @GetMapping
    public ResponseEntity<List<AutorDto>> getAll() throws Exception{
        try {
            return ResponseEntity.ok(new ArrayList<>(autorServicio.getAll()));
        }catch (Exception error) {
            List<AutorDto> autorDto = new ArrayList<>();
            autorDto.add(new AutorErrorDto(error.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(autorDto);
        }
    }
}