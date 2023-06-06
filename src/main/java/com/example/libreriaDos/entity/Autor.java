package com.example.libreriaDos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_autor")
    private Long id;
    private String nombre;
    private String apellido;
    private String pseudonimo;
    @Column(unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //para permitir el contenido application/json;charset=UTF-8 para poder crear registros
    //@JsonBackReference //sirve para mostrar el contenido de la otra entidad
    //no son compatibles
    private Pais pais;

}
