package com.example.libreriaDos.dto.ubicacion;

public class UbicacionErrorDto extends UbicacionDto{

    private String mensaje;

    public UbicacionErrorDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
