package com.juan.dispensador.dominio;



public class Cerveza {
    public String sabor;
    public String aroma;
    public String sensacionBoca;
    public double contenidoAlcohol;
    public String tipo;
    public  String marca;

    public Cerveza(String sabor, String aroma, String sensacionBoca, double contenidoAlcohol, String tipo, String marca) {
        this.sabor = sabor;
        this.aroma = aroma;
        this.sensacionBoca = sensacionBoca;
        this.contenidoAlcohol = contenidoAlcohol;
        this.tipo = tipo;
        this.marca = marca;
    }


    public String cerbezaActual(){
        String mensaje = "el sabor es" + sabor;

        return mensaje;
    }
}
