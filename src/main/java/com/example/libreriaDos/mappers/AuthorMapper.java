package com.example.libreriaDos.mappers;

import com.example.libreriaDos.dto.autor.AutorCorrectoDto;
import com.example.libreriaDos.entity.Autor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mappings({
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "apellido",target = "lastName"),
            @Mapping(source = "pseudonimo",target = "pseudonym")
    })
    AutorCorrectoDto toAutorDto(Autor autor);
    List<AutorCorrectoDto> toAutoresDto(List<Autor> autor);
    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Autor toAutor(AutorCorrectoDto autorCorrectoDto);
}
