package com.example.libreriaDos.mappers;

import com.example.libreriaDos.dto.ubicacion.UbicacionCorrectaDto;
import com.example.libreriaDos.entity.Ubicacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mappings({
            @Mapping(source = "piso", target = "floor"),
            @Mapping(source = "salon", target = "lounge"),
            @Mapping(source = "estante", target = "shelf")
    })
    UbicacionCorrectaDto toUbicacionCorrecta (Ubicacion ubicacion);

    List<UbicacionCorrectaDto> toUbicaciones (List<Ubicacion> ubicaciones);

    @InheritInverseConfiguration
    Ubicacion toUbicacion (UbicacionCorrectaDto ubicacionCorrectaDto);

}
