package org.example;

import model.*;

public class Main {
    public static void main(String[] args) {

        Biblioteca b1 = new Biblioteca();

        Libro l1 = new Libro("El Papel", 348, Color.BLANCOYNEGRO,
                "Antonio Cabanas", "El camino de los dioses", "1122443399441"
                , 5);

        b1.addLibro(l1);

        b1.addRevista(new Revista("La razón",98, Color.COLOR,
                "El Bienestar", Tematica.SALUD, Periodicidad.SEMANAL));

        b1.addPeriodico(new Periodico("ABC", 143, Color.COLOR,
                "El ABC", "22/06/2022"));


        Libro l2 = new Libro("La Editorial", 280, Color.BLANCOYNEGRO,
                "Miguel de Cervantes Saavedra", "Don Quijote de La Mancha", "4568125946321"
                , 6);

        b1.addLibro(l2);

        Socio s1 = new Socio("Ivan Perez", "48711233H");
        Socio s2 = new Socio("Juan Lopez", "85299963D");

        b1.addSocio(s1);
        b1.addSocio(s2);


        System.out.println(l1.printListaEjemplares());
        System.out.println();
        System.out.println();

        System.out.println(b1);
        System.out.println();

        System.out.println(b1.prestarLibro(l1, s1));
        System.out.println(b1.prestarLibro(l1, s1));
        System.out.println(b1.prestarLibro(l1, s1));
        System.out.println(b1.prestarLibro(l1, s1));
        System.out.println(b1.prestarLibro(l1, s1));
        System.out.println(b1.prestarLibro(l1, s2));
//        System.out.println(b1.devolverLibro(l1,s1));
//        System.out.println(b1.devolverLibro(l1,s1));
//        System.out.println(b1.prestarLibro(l1, s1));
//        System.out.println(b1.prestarLibro(l1, s1));




        System.out.println();

        System.out.println(l1.printListaEjemplares());
        System.out.println();

        //Esta línea hace referencia al préstamo concreto de este concreto ejemplar.
        System.out.println("'" + l1.getTitulo() + "'\n" + l1.getListaEjemplares().get(0).getListaPrestamos().get(0));
//        System.out.println(s1);
//        System.out.println(s2);
//
//        System.out.println();
//        System.out.println();
//        System.out.println(b1.devolverLibro(l1,s1));
//        System.out.println(b1.devolverLibro(l1,s1));
////        System.out.println(b1.prestarLibro(l1, s1));
//        System.out.println(b1.prestarLibro(l1, s1));
//
//        System.out.println();
//        System.out.println(l1.printListaEjemplares());
//        System.out.println(s1.printListaEjemplares());
//        System.out.println(s1);
//        System.out.println();
//        System.out.println(s2.printListaEjemplares());
//        System.out.println();
//
//
//


    }
}