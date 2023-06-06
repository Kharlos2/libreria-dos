package com.example.libreriaDos.service;

import com.example.libreriaDos.entity.Categoria;
import com.example.libreriaDos.repository.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicio implements ServiciosBase<Categoria>{

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Override
    public Categoria save(Categoria datos) throws Exception {
        try {
            if (categoriaRepositorio.existsByNombre(datos.getNombre())){
                throw new Exception("Este nombre ya existe");
            }else if (datos.getNombre().isEmpty()||datos.getDescripcion().isEmpty()){
                throw new Exception("Debe diligenciar todos los campos");
            }else {
                return categoriaRepositorio.save(datos);
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public List<Categoria> getAll() throws Exception {
        return categoriaRepositorio.findAll();
    }
}
