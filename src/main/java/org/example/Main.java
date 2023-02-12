package org.example;

import model.*;
import model.menu.Menu;
import model.menu.Opciones;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        Biblioteca b1 = new Biblioteca();
        int opcion;
        boolean terminado;
        boolean salir = false;
        String opcionesRegreso = "[1] Volver al menú principal → Pulse '1'\n" +
                "[2] Salir → Pulse '2'";

        Libro l1 = new Libro("El Papel", 348, Color.BLANCOYNEGRO,
                "Antonio Cabanas", "El camino de los dioses", "1122443399441"
                , 5);
        b1.addLibro(l1);

        Libro l2 = new Libro("La Editorial", 280, Color.BLANCOYNEGRO,
                "Miguel de Cervantes Saavedra", "Don Quijote de La Mancha", "4568125946321"
                , 6);
        b1.addLibro(l2);

        b1.addLibro(new Libro("La Editorial", 350, Color.BLANCOYNEGRO,
                "Jane Austen", "Orgullo y Prejuicio", "8521457956321"
                , 7));

        b1.addLibro(new Libro("Mesón", 430, Color.BLANCOYNEGRO,
                "Fyodor Dostoevsky", "Crimen y Castigo", "6541254896321"
                , 9));

        b1.addLibro(new Libro("Burgos Editores", 240, Color.BLANCOYNEGRO,
                "Mark Twain", "Las Aventuras de Tom Sawyer", "1235465478921"
                , 5));

        b1.addRevista(new Revista("La razón",98, Color.COLOR,
                "El Bienestar", Tematica.SALUD, Periodicidad.SEMANAL, new Date()));

        b1.addPeriodico(new Periodico("ABC", 143, Color.COLOR,
                "El ABC", new Date()));

        Socio s1 = new Socio("Ivan Perez", "48711233H");
        Socio s2 = new Socio("Juan Lopez", "85299963D");
        b1.addSocio(s1);
        b1.addSocio(s2);


        Menu m1 = new Menu(b1);
        System.out.println(m1.getMensajeInicio());

        do {
            for(String op : Opciones.opcionesIniciales()){
                System.out.println(op);
            }

            m1.selecOpcionesPrincipales();

            switch (m1.getOpcionSelecionada()) {
                case 1:
                    System.out.println(opcionesRegreso);
                    if(entrada.opciones1_2()==2)
                        salir = true;
                    break;
                case 2:
                    System.out.println(m1.isPrestado());
                    System.out.println(b1.getConfirmacion());
                    System.out.println(opcionesRegreso);
                    if(entrada.opciones1_2()==2)
                        salir = true;
                    break;
                case 3:
                    System.out.println(m1.isDevuelto());
                    System.out.println(b1.getConfirmacion());
                    System.out.println(opcionesRegreso);
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
                        System.out.println(opcionesRegreso);
                        if(entrada.opciones1_2()==2)
                            salir = true;
                        break;

                    case 5:
                        System.out.println(b1.getListaPrestamosLibro());
                        System.out.println(opcionesRegreso);
                        if(entrada.opciones1_2()==2)
                            salir = true;
                        break;

                    case 6:
                        System.out.println(b1.getListaPrestamosSocio());
                        System.out.println(opcionesRegreso);
                        if(entrada.opciones1_2()==2)
                            salir = true;
                        break;

                    case 7:
                        System.out.println("[1] Dar de alta → Pulse '1'\n" +
                                "[2] Dar de baja → Pulse '2'");
                        if(entrada.opciones1_2()==1){
                            if(b1.altaPublicacion())
                                System.out.println("Alta correcta");
                            else
                                System.out.println("Este libro ya esta dado de alta.");
                        }
                        else{
                            if(b1.bajaPublicacion())
                                System.out.println("Baja correcta");
                            else
                                System.out.println("Este libro ya esta dado de baja.");
                        }

                        System.out.println(opcionesRegreso);
                        if(entrada.opciones1_2()==2)
                            salir = true;
                        break;

                    case 8:
                        System.out.println("[1] Dar de alta → Pulse '1'\n" +
                                "[2] Dar de baja → Pulse '2'\n" +
                                "[3] Modificar → Pulse '3'");
                        opcion = entrada.opciones1_2_3();
                        if(opcion==1) {
                            if (b1.altaSocio())
                                System.out.println("Alta correcta");
                            else
                                System.out.println("El socio ya se encuentra dado de alta.");
                        }
                        else if (opcion==2){
                            if (b1.bajaSocio())
                                System.out.println("Baja correcta");
                            else
                                System.out.println("El socio ya se encuentra dado como dado de baja.");
                        }
                        else {
                            do {
                                System.out.println("[1] Modificar nombre → Pulse '1'\n" +
                                        "[2] Modificar DNI → Pulse '2'\n");
                                b1.modificarSocio();
                                System.out.println("¿Ha terminado?");
                                terminado = entrada.opcionSi_No();
                            }while(!terminado);
                        }

                        System.out.println(opcionesRegreso);
                        if(entrada.opciones1_2()==2)
                            salir = true;
                        break;

                    default:
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