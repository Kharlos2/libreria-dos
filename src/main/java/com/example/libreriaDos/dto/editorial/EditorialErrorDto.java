package com.example.libreriaDos.dto.editorial;

public class EditorialErrorDto extends EditorialDto{
    private String mensaje;

    public EditorialErrorDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
