package com.example.libreriaDos.dto.categoria;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoriaCorrectoDto extends CategoriaDto{

    private Long id;
    private String nombre;
    private String descripcion;

}
