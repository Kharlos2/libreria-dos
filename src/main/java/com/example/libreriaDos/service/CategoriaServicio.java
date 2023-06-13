package com.example.libreriaDos.service;

import com.example.libreriaDos.dto.categoria.CategoriaCorrectaDto;
import com.example.libreriaDos.dto.categoria.CategoriaDto;
import com.example.libreriaDos.entity.Categoria;
import com.example.libreriaDos.mappers.CategoryMapper;
import com.example.libreriaDos.mappers.EditorialMapper;
import com.example.libreriaDos.repository.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicio implements ServiciosBase<CategoriaCorrectaDto, Categoria>{

    @Autowired
    protected CategoriaRepositorio categoriaRepositorio;

    @Autowired
    protected CategoryMapper categoryMapper;
    @Override
    public CategoriaCorrectaDto save(Categoria datos) throws Exception {
        try {

            if (categoriaRepositorio.existsByNombre(datos.getNombre())){
                throw new Exception("Este nombre ya existe");
            }else if (datos.getNombre().isEmpty()||datos.getDescripcion().isEmpty()){
                throw new Exception("Debe diligenciar todos los campos");
            }else {
                return categoryMapper.toCategoriaCorrectaDto(categoriaRepositorio.save(datos));
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public List<CategoriaCorrectaDto> getAll() throws Exception {
        try {
            return categoryMapper.toCategoriasDto(categoriaRepositorio.findAll());

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
