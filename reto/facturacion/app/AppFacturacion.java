package com.juan.reto.facturacion.app;

import com.juan.reto.facturacion.dominio.Facturacion;
import com.juan.reto.facturacion.dominio.Persona;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class AppFacturacion {
    public static void main(String[] args) {


                




        Facturacion sistemaFacturacion = new Facturacion();
        byte opcionSeleccionada ;
        List<String> opcionCrearInfoValor = Arrays.asList("Crear Factura", "Informacion Facturas", "Valor total facutras");

        boolean proceso = true;
        while (proceso){
            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, "Facturacion", "Facturacion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, opcionCrearInfoValor.toArray(),"Crear Factura");
            switch (opcionSeleccionada) {
                case -1 -> proceso = false;
                case 0 -> {
                    String nombre = (String) JOptionPane.showInputDialog(null, "¿A nombre de quién va la factura?", "Ingreso de datos", JOptionPane.YES_NO_OPTION, null, null, "Nombre");
                    Persona propietario = new Persona(nombre);
                    Double valor = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingrese el valor de la factura", "Ingreso de datos", JOptionPane.YES_NO_OPTION, null, null, 0));
                    JOptionPane.showMessageDialog(null, "Ingrese la fecha(AAAA/MM/DD)");
                    int año = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingrese el año", "Ingreso de fecha", JOptionPane.YES_NO_OPTION, null, null, 0));
                    int mes = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingrese el mes", "Ingreso de fecha", JOptionPane.YES_NO_OPTION, null, null, 0));
                    int dia = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingrese el dia", "Ingreso de fecha", JOptionPane.YES_NO_OPTION, null, null, 0));
                    LocalDateTime fecha = LocalDateTime.of(año, mes, dia, 0, 0);
                    sistemaFacturacion.crearFactura(propietario, valor, fecha);
                }
                case 1 -> JOptionPane.showMessageDialog(null, sistemaFacturacion.obtenerInfoFacturas());
                case 2 -> JOptionPane.showMessageDialog(null, "El valor de su factura es\n"+ sistemaFacturacion.obtenerTotalFacturas());
            }
        }
    }
}
