package com.example.libreriaDos.entity;

import jakarta.persistence.*;


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
    //@JsonManagentReference //sirve para mostrar el contenido de la otra entidad
    //no son compatibles
    private Pais pais;

    public Autor() {
    }

    public Autor(Long id, String nombre, String apellido, String pseudonimo, String email, Pais pais) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pseudonimo = pseudonimo;
        this.email = email;
        this.pais = pais;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
