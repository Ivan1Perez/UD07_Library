package org.example;

import model.*;

public class Main {
    public static void main(String[] args) {

        Biblioteca b1 = new Biblioteca();

        System.out.println(b1.getListaRevistas());

        Libro l1 = new Libro("El Papel", 348, Color.BLANCOYNEGRO,
                "Antonio Cabanas", "El camino de los dioses", "1122443399441"
                , 5);

        b1.addLibro(l1);

        b1.addRevista(new Revista("La razón",98, Color.COLOR,
                "El Bienestar", Tematica.SALUD, Periodicidad.SEMANAL));

        b1.addPeriodico(new Periodico("ABC", 143, Color.COLOR,
                "El ABC", "22/06/2022"));

        System.out.println(l1.printListaEjemplares());


        Libro l2 = new Libro("La Editorial", 280, Color.BLANCOYNEGRO,
                "Miguel de Cervantes Saavedra", "Don Quijote de La Mancha", "4568125946321"
                , 6);

        b1.addLibro(l2);

        Socio s1 = new Socio("Ivan Perez", "48711233H");

        b1.addSocio(s1);

        System.out.println(b1.getListaLibros());
        System.out.println(b1.getListaRevistas());
        System.out.println(b1.getListaPeriodicos());
        System.out.println(b1.getListaSocios());
        System.out.println();
//        System.out.println(b1.prestamo("El camino de los dioss", s1));
//        System.out.println(b1.prestamo("El camino de los dioses", s1));
//        System.out.println(b1.prestamo("El camino de los dioses", s1));
//        System.out.println(b1.prestamo("El camino de los dioses", s1));
//        System.out.println(b1.prestamo("El camino de los dioses", s1));
//        System.out.println(b1.prestamo("El camino de los dioses", s1));
//        System.out.println(b1.prestamo("El camino de los dioses", s1));
//        System.out.println(b1.prestamo("El camino de los dioses", s1));


        System.out.println(l1.printListaEjemplares());
        System.out.println(s1);
        System.out.println();
        System.out.println();

        System.out.println(b1);

    }
}