package com.juan.lista_telefonica.dominio;

public class Contacto {
    private String nombreContacto;
    private String apellidoContacto;
    private int numeroContacto;

    public Contacto(String nombreContacto, String apellidoContacto, int numeroContacto) {
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.numeroContacto = numeroContacto;
    }

    public String getNombreContacto() {
        return this.nombreContacto;
    }

    public String getApellidoContacto() {
        return this.apellidoContacto;
    }

    public int getNumeroContacto() {
        return this.numeroContacto;
    }

    public void setNumeroContacto(int numeroContacto) {
        this.numeroContacto = numeroContacto;
    }
}
