

package com.juan.maquina_dispensadora.dominio;

public class Producto {
    private String nombreProducto;
    private int codigoProducto;
    private int unidadesDisponibles;
    private int valorUnidad;


    public Producto(String nombreProducto, int codigoProducto, int valorUnidad) {
        this.nombreProducto = nombreProducto;
        this.codigoProducto = codigoProducto;
        this.valorUnidad = valorUnidad;
        this.unidadesDisponibles = 8;
    }

    public Producto(String nombreProducto, int codigoProducto, int valorUnidad, int unidadesDisponibles) {
        this.nombreProducto = nombreProducto;
        this.codigoProducto = codigoProducto;
        this.valorUnidad = valorUnidad;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getNombre() {
        return this.nombreProducto;
    }

    public int getCodigoProducto() {
        return this.codigoProducto;
    }

    public int getValorUnidad() {
        return this.valorUnidad;
    }

    public int getUnidadesDisponibles() {
        return this.unidadesDisponibles;
    }

    public void setValorUnidad(int valorUnidad) {
        this.valorUnidad = valorUnidad;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }
}