package com.juan.reto.facturacion.dominio;

public class FacturaVencida extends Factura{
    long diasVencidos;
    double valorDiasVencidos;

    public FacturaVencida(double valor, Persona persona, long diasVencidos, double valorDiasVencidos) {
        super(valor, persona);
        this.diasVencidos = diasVencidos;
        this.valorDiasVencidos = valorDiasVencidos;
    }

    @Override
    public double calcularTotal() {
        return (valor + calcularDiasVencidos());
    }

    public double calcularDiasVencidos(){
        return diasVencidos * valorDiasVencidos;
    }
}
