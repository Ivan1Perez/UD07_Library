package org.example;

import model.*;
import model.menu.Menu;
import model.menu.Opciones;

public class Main {
    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        Biblioteca b1 = new Biblioteca();
        boolean salir = false;

//        System.out.println(b1.getListaLibros());

        Menu m1 = new Menu(b1);
        System.out.println(m1.getMensajeInicio());

        do {
            for(String op : Opciones.opcionesIniciales()){
                System.out.println(op);
            }

            m1.selecOpcionesPrincipales();

            switch (m1.getOpcionSelecionada()) {
                case 1:
                    for (String op : Opciones.opcionesRegreso())
                        System.out.println(op);
                    if(entrada.opciones1_2()==2)
                        salir = true;
                    break;
                case 2:
                    System.out.println(m1.isPrestado());
                    System.out.println(b1.getConfirmacion());
                    for (String op : Opciones.opcionesRegreso())
                        System.out.println(op);
                    if(entrada.opciones1_2()==2)
                        salir = true;
                    break;
                case 3:
                    System.out.println(m1.isDevuelto());
                    System.out.println(b1.getConfirmacion());
                    for (String op : Opciones.opcionesRegreso())
                        System.out.println(op);
                    if(entrada.opciones1_2()==2)
                        salir = true;
                    break;
                case 4:
                    for (String op : Opciones.masOpciones()) {
                        System.out.println(op);
                    }
                    break;
                case 5:
                    salir = true;
            }

            //INICIO menú 'Ver más opciones' (case 4)

            if (m1.getOpcionSelecionada() == 4) {
                m1.selecMasOpciones();
                switch (m1.getOpcionSelecionada()) {
                    case 1, 2, 3, 4:
                        System.out.println(m1.getListaSE());
                        for (String op : Opciones.opcionesRegreso())
                            System.out.println(op);
                        if(entrada.opciones1_2()==2)
                            salir = true;
                        break;

                    case 5:
                        System.out.println(b1.getListaPrestamos());
                        for (String op : Opciones.opcionesRegreso())
                            System.out.println(op);
                        if(entrada.opciones1_2()==2)
                            salir = true;
                        break;

                }
            }

            //FIN menú 'Ver más opciones' (case 4)

            if(salir)
                System.out.println("Hasta luego!");

        }while(!salir);



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