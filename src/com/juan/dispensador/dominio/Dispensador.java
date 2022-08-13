package com.juan.dispensador.dominio;

public class Dispensador {
    public double capacidad;
    public double cantidadActual;
    public double temperatura;
    public Cerveza producto;
    public boolean activa;

    public Dispensador(double cantidadActual, double temperatura, Cerveza producto) {
        this.capacidad = 10000;
        this.cantidadActual = cantidadActual;
        this.temperatura = temperatura;
        this.producto = producto;
        this.activa = true;
    }

    public boolean Servir(double cantidadServir, Cerveza tipo) {

        if (this.activa) {
            if (cantidadServir < cantidadActual) {
                System.out.println("estamos sirviendo su cerveza");
            } else {
                System.out.println("el Dispensador no tiene la cantidad sufuciente, la cantidad actual es: " + cantidadActual);
                return false;
            }
            if (temperatura <= 10 && temperatura >= -10) {
                System.out.println("la cerveza esta optima para Servir");

            } else {
                System.out.println("por favor, espere mientras la cerveza se coloca en la temperatura correcta");
                return false;
            }
            if (cantidadActual < 0) {
                System.out.println("por favor llene el dispensador");
                return false;
            }
            this.cantidadActual = this.cantidadActual - cantidadServir;
            System.out.println("disfrute su cerveza");
        }
        return false;
    }


    public Boolean cambiarTemperatura( double nuevaTemperatura) {
        temperatura = nuevaTemperatura;
        return false;
    }

    public boolean llenarDispensador(){
        cantidadActual = 10000;
        return false;
    }

    public boolean vaciarDispensador(){
        cantidadActual = 0;
        return false;
    }




    public String consultarCantidad() {
        String mensaje = "el contenido actual es: " + cantidadActual + " mililitros";
        return mensaje;
    }

    public String consultarTemperatura() {
        String mensaje = "la temperatura actual es: " + temperatura + " °C";
        return mensaje;
    }



}


