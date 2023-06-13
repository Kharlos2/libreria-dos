package com.example.libreriaDos.mappers;

import com.example.libreriaDos.dto.categoria.CategoriaCorrectaDto;
import com.example.libreriaDos.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping( source = "nombre", target = "name"),
            @Mapping(source = "descripcion",target = "description")
    })
    CategoriaCorrectaDto toCategoriaCorrectaDto (Categoria categoria);
    List<CategoriaCorrectaDto> toCategoriasDto(List<Categoria> categorias);
    @InheritInverseConfiguration
    Categoria toCategoria (CategoriaCorrectaDto categoriaCorrectaDto);

}
