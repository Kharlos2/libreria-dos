package com.example.libreriaDos.controller;

import com.example.libreriaDos.dto.editorial.EditorialDto;
import com.example.libreriaDos.dto.editorial.EditorialErrorDto;
import com.example.libreriaDos.entity.Editorial;
import com.example.libreriaDos.service.EditorialServicio;

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
@RequestMapping("editoriales")
public class EditorialControlador {

    @Autowired
    private EditorialServicio editorialServicio;

    @Operation(summary = "Guarda una editorial")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Editorial guardada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Editorial.class)) }),
            @ApiResponse(responseCode = "400", description = "Editorial no valida",
                    content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<EditorialDto> save(@RequestBody Editorial datos) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(editorialServicio.save(datos));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new EditorialErrorDto(error.getMessage()));
        }
    }
    @Operation(summary = "Busca todos las editoriales")
    @GetMapping
    public ResponseEntity<List<EditorialDto>> getAll() throws Exception {
        try{
            return ResponseEntity.ok(new ArrayList<>(editorialServicio.getAll()));
        }catch (Exception error){
            List<EditorialDto> editorialDtos = new ArrayList<>();
            editorialDtos.add(new EditorialErrorDto(error.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(editorialDtos);

        }
    }


}
