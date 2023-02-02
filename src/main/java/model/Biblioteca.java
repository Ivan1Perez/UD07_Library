package model;

import model.menu.OpcionesIniciales;
import java.util.Scanner;

public class Biblioteca {

    private OpcionesIniciales opcionesIniciales;
    private Entrada entrada;
    protected static final ListaLibros listaLibros = new ListaLibros();
    protected static final ListaRevistas listaRevistas = new ListaRevistas();

//    private ListaRevistas listaRevistas;
//    private ListaPeriodicos listaPeriodicos;
//    private listaSocios listaSocios;


    public Biblioteca() {
//        System.out.println(opcionesIniciales = new OpcionesIniciales());
//        new Entrada();
    }

    public static ListaLibros getListaLibros(){
        return listaLibros;
    }

    public static ListaRevistas getListaRevistas(){
        return listaRevistas;
    }

}
