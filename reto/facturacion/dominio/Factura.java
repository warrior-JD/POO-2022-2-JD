package com.juan.reto.facturacion.dominio;

import java.time.LocalDateTime;

public class Factura {
    protected int numero;
    protected LocalDateTime fecha;
    protected double valor;
    protected Persona persona;

    private static int contador = 1;

    public Factura(double valor, Persona persona){
        this.valor = valor;
        this.persona = persona;
        this.numero = contador++;
        this.fecha = LocalDateTime.now();
    }

    public double calcularTotal() {
        return 0;
    }
}
