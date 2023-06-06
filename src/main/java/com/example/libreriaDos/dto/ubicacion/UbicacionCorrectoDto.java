package com.example.libreriaDos.dto.ubicacion;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UbicacionCorrectoDto extends UbicacionDto{
    private Long id;
    private String piso;
    private String salon;
    private String estante;

}
