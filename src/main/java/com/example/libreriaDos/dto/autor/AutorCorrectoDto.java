package com.example.libreriaDos.dto.autor;

import com.example.libreriaDos.entity.Pais;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorCorrectoDto extends AutorDto{

    private Long id;
    private String nombre;
    private String apellido;
    private String pseudonimo;
    private String email;
    private Pais pais;


}
