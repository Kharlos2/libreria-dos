package com.example.libreriaDos.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private Long id;
    @Column(unique = true)
    private String nombre;
    @OneToMany(mappedBy = "pais",cascade = CascadeType.ALL)
    @JsonIgnore
    //@JsonBackReference
    private List<Autor> autores;

    public Pais() {
    }

    public Pais(Long id, String nombre, List<Autor> autores) {
        this.id = id;
        this.nombre = nombre;
        this.autores = autores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
