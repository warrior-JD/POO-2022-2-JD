package com.juan.dispensador.app;

import com.juan.dispensador.dominio.Cerveza;
import com.juan.dispensador.dominio.Dispensador;

public class AppDispensador {
    public static void main(String[] args){

        Cerveza negra = new Cerveza("chocolate", "chocolate", "amargo", 5, "negra", "guinness");
        Cerveza lager = new Cerveza("tostado", "malta", "suave", 4, "lager",  "modelo");

        Dispensador dispensador1 = new Dispensador(8000,10,negra);
        Dispensador dispensador2 = new Dispensador(8000,0, lager);

        dispensador2.cambiarTemperatura(7);
        dispensador1.Servir(2000, negra);
        dispensador1.llenarDispensador();
        dispensador2.vacearDispensador();


        System.out.println(dispensador1.consultarCantidad());
        System.out.println(dispensador1.consultarTemperatura());

        System.out.println(dispensador2.consultarTemperatura());
        System.out.println(dispensador2.consultarCantidad());






    }



























}


