package org.example;

import model.*;
import model.menu.Menu;

public class Main {
    public static void main(String[] args) {

        Biblioteca b1 = new Biblioteca();

//        System.out.println(b1.getListaLibros());
//        System.out.println(b1.prestarLibro("don", "48711233H"));
//        System.out.println(b1.prestarLibro("don", "48711233H"));

        Menu m1 = new Menu(b1);
        System.out.println(m1.getMensajeInicio());
        for(String op : m1.getOpcionesIniciales()){
            System.out.println(op);
        }

        m1.selecOpcionesPrincipales();

        switch (m1.getOpcionSelecionada()){
            case 1:
                System.out.println(m1.getLibro());
                System.out.println(b1.getConfirmacion());
                break;
            case 2:
                System.out.println(m1.isPrestado());
                System.out.println(b1.getConfirmacion());
                break;
            case 3:
                System.out.println(m1.isDevuelto());
                System.out.println(b1.getConfirmacion());
                break;
            case 4:
                for(String op : m1.getMasOpciones()){
                    System.out.println(op);
                }
                m1.selecMasOpciones();
                System.out.println(m1.getListaSE());
                break;
            case 5:
                System.out.println("Hasta luego!");
        }



//        System.out.println(l1.getListaEjemplares());
////        System.out.println();
//        System.out.println();
////
////        System.out.println(b1);
//        System.out.println();
//
//        System.out.println(b1.prestarLibro(l1, s1));
//        System.out.println(b1.prestarLibro(l1, s1));
//        System.out.println(b1.prestarLibro(l2, s1));
//        System.out.println(b1.prestarLibro(l1, s1));
//        System.out.println(b1.devolverLibro(l1,s1));
//        System.out.println(b1.prestarLibro(l1, s1));
//
//
//        System.out.println();
//        System.out.println(l1.getListaEjemplares());
//        System.out.println(s1.getListaEjemplares());
//        System.out.println(s1);
//
//        System.out.println(l1.getListaEjemplares().get(0).getListaPrestamos());


    }
}