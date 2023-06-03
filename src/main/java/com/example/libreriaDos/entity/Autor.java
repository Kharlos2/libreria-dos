package com.example.libreriaDos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(unique = true)
    private String pseudonimo;
    @Column(unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    @JsonManagedReference
    private Pais pais;

}
