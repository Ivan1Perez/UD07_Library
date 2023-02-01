package org.example;

import model.*;

public class Main {
    public static void main(String[] args) {

        Libro l1 = new Libro("El Papel", 348, Color.BLANCOYNEGRO,
                "Antonio Cabanas", "El camino de los dioses",
                5);

        System.out.println(l1);

        Revista r1 = new Revista("La razón",98, Color.COLOR,
                "El Bienestar", Tematica.SALUD, Periodicidad.SEMANAL);

        System.out.println(r1);

        Periodico p1 = new Periodico("ABC", 143, Color.COLOR,
                "El ABC", "22/06/2022");

        System.out.println(p1);

        System.out.println(l1.getListaLibro());

        System.out.println("Prestar libro 'El camino de los dioses'\nPréstamo realizado: " + l1.prestamo("El camino de los dioses"));
        System.out.println();

        System.out.println(l1.getListaLibro());


    }
}