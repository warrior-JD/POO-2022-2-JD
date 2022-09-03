package com.juan.lista_telefonica.app;

import com.juan.lista_telefonica.dominio.Contacto;
import com.juan.lista_telefonica.dominio.Agenda;

public class AppAgenda {
    public AppAgenda() {
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda("jd");
        Contacto contacto1 = new Contacto("pedro", "pica", 1234);
        Contacto contacto2 = new Contacto("sara", "castro", 5678);
        Contacto contacto3 = new Contacto("melisa", "suarez", 9012);
        Contacto contacto4 = new Contacto("Andres", "perez", 3456);
        agenda.agregar(contacto1);
        agenda.agregar(contacto2);
        agenda.agregar(contacto3);
        agenda.agregar(contacto4);
        agenda.buscar("sara", "castro");
        agenda.buscar(243334);
        agenda.eliminar(contacto1);
    }
}