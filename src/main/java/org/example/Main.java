package org.example;

import model.*;
import model.menu.Menu;

import java.util.Date;

public class Main {
    public static <T> void main(String[] args) {

        Biblioteca b1 = new Biblioteca();

//        System.out.println(b1.getListaLibros());

        Menu m1 = new Menu(b1);
        System.out.println(m1.getMensajeInicio());
        for(String op : m1.opcionesIniciales()){
            System.out.println(op);
        }

        m1.selecOpcionesIniciales();

        switch (m1.getOpcionSelecionada()){
            case 1:
                System.out.println(m1.getLibro());
                break;
            case 2:
                System.out.println(m1.isPrestado());
                break;
            case 3:
                System.out.println(m1.isDevuelto());
                break;
            case 4:
                for(String op : m1.opcionesTotales()){
                    System.out.println(op);
                }
                m1.selecOpcionesTotales();
                System.out.println(m1.getListaSE());
                break;
            case 5:
                System.out.println("Hasta luego!");
        }

//        if(opcionSelecionada instanceof Libro){
//            System.out.println(m1.getLibro());
//        }
//        else if (opcionSelecionada instanceof Boolean)
//            System.out.println(m1.isPrestado());
//


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