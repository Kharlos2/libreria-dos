package com.example.libreriaDos.controller;

import com.example.libreriaDos.dto.ubicacion.UbicacionCorrectoDto;
import com.example.libreriaDos.dto.ubicacion.UbicacionDto;
import com.example.libreriaDos.dto.ubicacion.UbicacionErrorDto;
import com.example.libreriaDos.entity.Ubicacion;
import com.example.libreriaDos.service.UbicacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ubicaciones")
public class UbicacionControlador {
    @Autowired
    private UbicacionServicio ubicacionServicio;
    @PostMapping("/save")
    public ResponseEntity<UbicacionDto> save(@RequestBody Ubicacion datos) throws Exception {
        try {
            ubicacionServicio.save(datos);
            UbicacionCorrectoDto mensaje = new UbicacionCorrectoDto();
            mensaje.setId(datos.getId());
            mensaje.setEstante(datos.getEstante());
            mensaje.setPiso(datos.getPiso());
            mensaje.setSalon(datos.getSalon());
            return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
        }catch (Exception error){
            UbicacionErrorDto mensaje = new UbicacionErrorDto();
            mensaje.setMansaje(error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
        }
    }
    @GetMapping
    public ResponseEntity<List<Ubicacion>> getAll() throws Exception{
        return ResponseEntity.ok(ubicacionServicio.getAll());
    }
}
