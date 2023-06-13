package com.example.libreriaDos.controller;

import com.example.libreriaDos.dto.ubicacion.UbicacionDto;
import com.example.libreriaDos.dto.ubicacion.UbicacionErrorDto;
import com.example.libreriaDos.entity.Ubicacion;
import com.example.libreriaDos.service.UbicacionServicio;
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
@RequestMapping("ubicaciones")
public class UbicacionControlador {
    @Autowired
    private UbicacionServicio ubicacionServicio;

    @Operation(summary = "Guarda una ubicación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ubicación guardada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Ubicacion.class)) }),
            @ApiResponse(responseCode = "400", description = "Ubicación no valida",
                    content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<UbicacionDto> save(@RequestBody Ubicacion datos) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(ubicacionServicio.save(datos));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UbicacionErrorDto(error.getMessage()));
        }
    }
    @Operation(summary = "Busca todos las ubicaciones")
    @GetMapping
    public ResponseEntity<List<UbicacionDto>> getAll() throws Exception {
        try {
            return ResponseEntity.ok(new ArrayList<>(ubicacionServicio.getAll()));
        } catch (Exception error) {
            List<UbicacionDto> ubicacionDtos = new ArrayList<>();
            ubicacionDtos.add(new UbicacionErrorDto(error.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ubicacionDtos);
        }
    }
}
