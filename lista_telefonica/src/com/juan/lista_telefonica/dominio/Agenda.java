package com.juan.lista_telefonica.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Agenda {


    private String agenda;
    private List<Contacto> contactos;

    public Agenda(String agenda) {
        this.agenda = agenda;
        this.contactos = new ArrayList();
    }

    public Contacto buscar(String nombreContacto, String apellidoContacto) {
        Contacto contactoBuscado = null;
        Iterator cont = this.contactos.iterator();

        while(cont.hasNext()) {
            Contacto contacto = (Contacto)cont.next();
            if (contacto.getNombreContacto().equalsIgnoreCase(nombreContacto)) {
                contactoBuscado = contacto;
            }

            if (contacto.getApellidoContacto().equalsIgnoreCase(apellidoContacto)) {
                contactoBuscado = contacto;
            }
        }

        return contactoBuscado;
    }

    public Contacto buscar(int numeroContacto) {
        Contacto contactoBuscado = null;
        Iterator cont = this.contactos.iterator();

        while(cont.hasNext()) {
            Contacto contacto = (Contacto) cont.next();
            if (contacto.getNumeroContacto() == numeroContacto) {
                contactoBuscado = contacto;
                break;
            }
        }

        return contactoBuscado;
    }

    public boolean agregar(Contacto contacto) {
        if (this.contactos.size() < 20) {
            Contacto c = this.buscar(contacto.getNumeroContacto());
            if (c == null) {
                this.contactos.add(contacto);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean eliminar(Contacto contacto) {
        Contacto c = this.buscar(contacto.getNumeroContacto());
        if (c == null) {
            this.contactos.remove(contacto);
            return true;
        } else {
            return false;
        }
    }






}
