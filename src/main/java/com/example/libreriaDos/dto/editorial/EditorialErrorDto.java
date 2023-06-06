package com.example.libreriaDos.dto.editorial;

import com.example.libreriaDos.dto.editorial.EditorialDto;

public class EditorialErrorDto extends EditorialDto {

    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
