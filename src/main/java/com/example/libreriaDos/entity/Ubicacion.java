package com.example.libreriaDos.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "ubicaciones")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private Long id;
    private String piso;
    private String salon;
    private String estante;

    public Ubicacion() {
    }

    public Ubicacion(Long id, String piso, String salon, String estante) {
        this.id = id;
        this.piso = piso;
        this.salon = salon;
        this.estante = estante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }
}
