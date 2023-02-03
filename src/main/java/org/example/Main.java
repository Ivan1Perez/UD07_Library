package org.example;

import model.*;

public class Main {
    public static void main(String[] args) {

        Biblioteca b1 = new Biblioteca();

        System.out.println(b1.getListaLibros());

        Libro l1 = new Libro("El Papel", 348, Color.BLANCOYNEGRO,
                "Antonio Cabanas", "El camino de los dioses", "1122443399441"
                , 5);
//
//        System.out.println(l1);
//
        Revista r1 = new Revista("La razón",98, Color.COLOR,
                "El Bienestar", Tematica.SALUD, Periodicidad.SEMANAL);
//
//        System.out.println(r1);
//
        Periodico p1 = new Periodico("ABC", 143, Color.COLOR,
                "El ABC", "22/06/2022");
//
//        System.out.println(p1);
//
        System.out.println(l1.printListaEjemplares());
//
////        System.out.println("Prestar libro 'El camino de los dioses'\nPréstamo realizado: " + l1.prestamo("El camino de los dioses"));
//        System.out.println();
//
//        System.out.println(l1);
//
        Libro l2 = new Libro("La Editorial", 280, Color.BLANCOYNEGRO,
                "Miguel de Cervantes Saavedra", "Don Quijote de La Mancha", "4568125946321"
                , 6);

        Socio s1 = new Socio("Ivan Perez", "48711233H");

        System.out.println(b1.getListaLibros());
        System.out.println(b1.getListaRevistas());
        System.out.println(b1.getListaPeriodicos());
        System.out.println(b1.getListaSocios());
        System.out.println();
        System.out.println(b1.prestamo("El camino de los dioses", s1));
        System.out.println(b1.prestamo("El camino de los dioses", s1));
        System.out.println(b1.prestamo("El camino de los dioses", s1));
        System.out.println(b1.prestamo("El camino de los dioses", s1));

        System.out.println(l1.printListaEjemplares());
        System.out.println(b1.getListaLibros());
        System.out.println(s1);

    }
}