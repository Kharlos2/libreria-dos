package com.example.libreriaDos.service;


import java.util.regex.Pattern;

public class Verificacion {

    public static boolean verificarCorreo(String email){
        if (email == null) {
            return true;
        }
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        if (pattern.matcher(email).find()) {
            return false;
        }
        return true;
    }
    public static boolean verficarPseudonimoONombreApellido(String nombre, String apellido, String pseudonimo){
        if ((!nombre.isEmpty() && !apellido.isEmpty())||!pseudonimo.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }

}
