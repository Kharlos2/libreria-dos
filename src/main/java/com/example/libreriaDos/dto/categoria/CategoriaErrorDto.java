package com.example.libreriaDos.dto.categoria;

public class CategoriaErrorDto extends CategoriaDto {

    private String mensaje;

    public CategoriaErrorDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
