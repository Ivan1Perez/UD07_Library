package model;

import model.menu.OpcionesIniciales;
import java.util.Scanner;

public class Biblioteca {

    private OpcionesIniciales opcionesIniciales;
    private Entrada entrada;
    private Libro libro;
    protected static final ListaLibros listaLibros = new ListaLibros();
    protected static final ListaRevistas listaRevistas = new ListaRevistas();
    protected static final ListaPeriodicos listaPeriodicos = new ListaPeriodicos();
    protected static final ListaSocios listaSocios = new ListaSocios();

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

    public static ListaPeriodicos getListaPeriodicos(){
        return listaPeriodicos;
    }

    public static ListaSocios getListaSocios(){
        return listaSocios;
    }

    public boolean prestamo(){

    }

}
