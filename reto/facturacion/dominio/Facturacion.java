package com.juan.reto.facturacion.dominio;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

import com.juan.reto.facturacion.app.AppFacturacion;
import com.juan.retos.guayavita.app.AppJuego;

import javax.swing.*;

public class Facturacion {
    ImageIcon dado1;
    byte tiroDado;

    {
        try {
            dado1 = new ImageIcon(AppFacturacion.class.getResourceAsStream("1.jpg").readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ImageIcon dado2;

    {
        try {
            dado2 = new ImageIcon(AppFacturacion.class.getResourceAsStream("2.jpg").readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ImageIcon dado3;

    {
        try {
            dado3 = new ImageIcon(AppFacturacion.class.getResourceAsStream("3.jpg").readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ImageIcon dado4;

    {
        try {
            dado4 = new ImageIcon(AppFacturacion.class.getResourceAsStream("4.jpg").readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ImageIcon dado5;

    {
        try {
            dado5 = new ImageIcon(AppFacturacion.class.getResourceAsStream("5.jpg").readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ImageIcon dado6;

    {
        try {
            dado6 = new ImageIcon(AppFacturacion.class.getResourceAsStream("6.jpg").readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final double IVA_19 = 0.19;
    private static final double valorDiasVencidos = 0.06;
    private static final double DESCUENTO1 = 0.1;
    private static final double DESCUENTO2 = 0.13;
    private static final double DESCUENTO3 = 0.09;
    private static final double DESCUENTO4 = 0.5;
    private static final double DESCUENTO5 = 0.05;
    private static final double DESCUENTO6 = 0.4;
    private List<Factura> facturas;

    public Facturacion() {
        this.facturas = new ArrayList<>();
    }

    public void crearFactura(Persona persona, double valor, LocalDateTime fecha) {
        Factura factura = null;

        if (diasVencidos(fecha, LocalDateTime.now()) != 0){


            long diasVencidos = diasVencidos(fecha, LocalDateTime.now());
            factura = new FacturaVencida(valor, persona, diasVencidos, valorDiasVencidos);

        } else if (valor>150000) {


                tiroDado = persona.tirarDado();
                switch (tiroDado) {
                    case 1:
                        mostrarMensaje("Su dado ha sido 1 el descuento es del 10%", dado1);

                        factura = new FacturaConDescuento(valor, persona, DESCUENTO1);
                        break;
                    case 2:
                        mostrarMensaje("Su dado ha sido 2 el descuento es del 13%", dado2);
                        factura = new FacturaConDescuento(valor, persona, DESCUENTO2);
                        break;
                    case 3:
                        mostrarMensaje("Su dado ha sido 3 el descuento es del 9%", dado3);
                        factura = new FacturaConDescuento(valor, persona, DESCUENTO3);
                        break;
                    case 4:
                        mostrarMensaje("Su dado ha sido 4 el descuento es del 50%", dado4);
                        factura = new FacturaConDescuento(valor, persona, DESCUENTO4);
                        break;
                    case 5:
                        mostrarMensaje("Su dado ha sido 5 el descuento es del 05%", dado5);
                        factura = new FacturaConDescuento(valor, persona, DESCUENTO5);
                        break;
                    case 6:
                        mostrarMensaje("Su dado ha sido 6 el descuento es del 40%", dado6);
                        factura = new FacturaConDescuento(valor, persona, DESCUENTO6);
                }




        } else if (persona.getNombre().length()<5){
            factura = new FacturaSinIva(valor, persona);

        } else {
            factura = new FacturaConIva(valor,persona, IVA_19);
        }

        this.facturas.add(factura);
    }

    public List<String> obtenerInfoFacturas(){
        return this.facturas.stream().map(fac -> {
            return "Factura #" + fac.numero + " a nombre de " + fac.persona.getNombre() + " - $" + fac.calcularTotal() + "\n";
        }).collect(Collectors.toList());
    }

    public double obtenerTotalFacturas() {
        return this.facturas.stream().mapToDouble(fac -> fac.calcularTotal()).sum();
    }

    private boolean comienzaVocal(String nombre){
        return "aeiouAEIOU".indexOf(nombre.charAt(0))>=0;
    }

    public long diasVencidos(LocalDateTime inicio, LocalDateTime fin){
        return DAYS.between(inicio, fin);
    }

    public static void mostrarMensaje(String mensaje, ImageIcon icon) {
        JOptionPane.showMessageDialog((Component)null, "" + mensaje, "Facturacion", -1, icon);
    }


}
