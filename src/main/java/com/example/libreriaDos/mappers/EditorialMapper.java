package com.example.libreriaDos.mappers;

import com.example.libreriaDos.dto.editorial.EditorialCorrectaDto;
import com.example.libreriaDos.dto.editorial.EditorialDto;
import com.example.libreriaDos.entity.Editorial;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditorialMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description")
    })
    EditorialCorrectaDto toEditorialCorrecta (Editorial editorial);

    List<EditorialCorrectaDto> toEditorialesDto(List<Editorial> editoriales);
    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Editorial toEditorialCorrectoDto(EditorialCorrectaDto editorialCorrectoDto);
}
