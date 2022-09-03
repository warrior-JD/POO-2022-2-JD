package com.juan.maquina_dispensadora.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Maquina {
    private String nombre;
    private List<Producto> productos;


    public Maquina(String nombreProducto) {
        this.nombre = nombre;
        this.productos = new ArrayList();
    }

    public Producto buscarProducto(int codigoProducto) {
        Producto productoBuscado = null;
        Iterator var3 = this.productos.iterator();

        while (var3.hasNext()) {
            Producto producto = (Producto) var3.next();
            if (producto.getCodigoProducto() == codigoProducto) {
                productoBuscado = producto;
                break;
            }
        }

        return productoBuscado;
    }

    public Producto buscarProducto(String nombreProducto) {
        Producto productoBuscado = null;
        Iterator var3 = this.productos.iterator();

        while (var3.hasNext()) {
            Producto producto = (Producto) var3.next();
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                productoBuscado = producto;
                break;
            }
        }

        return productoBuscado;
    }

    public boolean agregarProducto(Producto producto) {
        if (this.productos.size() < 10) {
            Producto pro = this.buscarProducto(producto.getCodigoProducto());
            if (pro == null) {
                this.productos.add(producto);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean sacarProducto(Producto producto) {
        if (producto != null) {
            producto.setUnidadesDisponibles(producto.getUnidadesDisponibles() - 1);
            return true;
        } else {
            return false;
        }
    }

    public boolean sacarUnidad(int codigoProducto) {
        Producto mecatoBuscado = this.buscarProducto(codigoProducto);
        return this.sacarProducto(mecatoBuscado);
    }

    public boolean sacarUnidad(String nombreProducto) {
        Producto mecatoBuscado = this.buscarProducto(nombreProducto);
        return this.sacarProducto(mecatoBuscado);
    }

    public List<String> consultarAgotados() {
        new ArrayList();
        return (List<String>) (List) this.productos.stream().filter((pro) -> {
            return pro.getUnidadesDisponibles() == 0;
        }).map((pro) -> {
            return pro.getNombre();
        }).collect(Collectors.toList());
    }

    public int consultarUnidades(int codigoProducto) {
        Producto mecatoBuscado = this.buscarProducto(codigoProducto);
        return this.consultarUnidades(mecatoBuscado);
    }

    public int consultarUnidades(String nombreProducto) {
        Producto mecatoBuscado = this.buscarProducto(nombreProducto);
        return this.consultarUnidades(mecatoBuscado);
    }

    private int consultarUnidades(Producto producto) {
        return producto != null ? producto.getUnidadesDisponibles() : 0;
    }



    public void aumentarStock(int codigoProducto, int cantidadAumentar) {
        Producto producto = this.buscarProducto(codigoProducto);
        if (producto != null) {
            if (producto.getUnidadesDisponibles() + cantidadAumentar < 6) {
                producto.setUnidadesDisponibles(producto.getUnidadesDisponibles() + cantidadAumentar);
            } else {
                producto.setUnidadesDisponibles(8);
            }
        }

    }
}
