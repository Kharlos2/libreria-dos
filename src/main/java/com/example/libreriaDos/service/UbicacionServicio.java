package com.example.libreriaDos.service;

import com.example.libreriaDos.entity.Ubicacion;
import com.example.libreriaDos.repository.UbicacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionServicio implements ServiciosBase<Ubicacion>{

    @Autowired
    private UbicacionRepositorio ubicacionRepositorio;
    @Override
    public Ubicacion save(Ubicacion datos) throws Exception {
        try {
            if (datos.getEstante().isEmpty()||datos.getPiso().isEmpty()||datos.getSalon().isEmpty()){
                throw new Exception("Es necesario llenar todos los campos");
            }
            else {
                return ubicacionRepositorio.save(datos);
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public List<Ubicacion> getAll() throws Exception {
        return ubicacionRepositorio.findAll();
    }
}
