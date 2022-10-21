package com.juan.reto.facturacion.dominio;

public class Persona {
    private String nombre;
    private String apellido;

    public Persona(String nombre) {
        this.nombre = nombre;
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

    public byte tirarDado() {
        return (byte)((int)(Math.random() * 6.0 + 1.0));
    }
}
