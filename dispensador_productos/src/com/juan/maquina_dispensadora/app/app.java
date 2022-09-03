package com.juan.maquina_dispensadora.app;

import com.juan.maquina_dispensadora.dominio.Maquina;
import com.juan.maquina_dispensadora.dominio.Producto;


public class app {
    public app() {
    }

    public static void main(String[] args) {
        Maquina dispensador = new Maquina("JD");
        Producto producto1 = new Producto("papitas", 01, 1500, 5);
        Producto producto2 = new Producto("gaseosa", 02, 2000, 2);
        Producto producto3 = new Producto("salchicha", 03, 3000, 6);
        Producto producto4 = new Producto("chocolatina", 04, 500, 2);
        dispensador.agregarProducto(producto1);
        dispensador.agregarProducto(producto2);
        dispensador.agregarProducto(producto3);
        dispensador.agregarProducto(producto4);
        dispensador.sacarUnidad(2);
        dispensador.sacarUnidad("papitas");
        dispensador.aumentarStock(03, 2);
        dispensador.consultarUnidades(02);
        dispensador.consultarUnidades("papitas");
        System.out.println(dispensador.consultarAgotados());

    }
}
