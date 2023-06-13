package com.example.libreriaDos.service;

import com.example.libreriaDos.dto.ubicacion.UbicacionCorrectaDto;
import com.example.libreriaDos.entity.Ubicacion;
import com.example.libreriaDos.mappers.LocationMapper;
import com.example.libreriaDos.repository.UbicacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionServicio implements ServiciosBase<UbicacionCorrectaDto,Ubicacion>{

    @Autowired
    protected UbicacionRepositorio ubicacionRepositorio;

    @Autowired
    protected LocationMapper locationMapper;
    @Override
    public UbicacionCorrectaDto save(Ubicacion datos) throws Exception {
        try {
            if (datos.getEstante().isEmpty()||datos.getPiso().isEmpty()||datos.getSalon().isEmpty()){
                throw new Exception("Es necesario llenar todos los campos");
            }
            else {
                return locationMapper.toUbicacionCorrecta(ubicacionRepositorio.save(datos));
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public List<UbicacionCorrectaDto> getAll() throws Exception {
        try {
            return locationMapper.toUbicaciones(ubicacionRepositorio.findAll());

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
