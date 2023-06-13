package com.example.libreriaDos.dto.autor;

public class AutorErrorDto extends AutorDto{

    private String mensaje;

    public AutorErrorDto(String mensaje) {this.mensaje = mensaje;}

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
