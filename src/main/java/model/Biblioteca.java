package model;

import model.menu.OpcionesIniciales;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Biblioteca {

    private OpcionesIniciales opcionesIniciales;
    private Entrada entrada;
    private Libro libro;
    private ListaPublicaciones listaLibros;
    private ListaPublicaciones listaRevistas;
    private ListaPublicaciones listaPeriodicos;
    private ListaSocios listaSocios;

    public Biblioteca() {
//        System.out.println(opcionesIniciales = new OpcionesIniciales());
//        new Entrada();

        listaLibros = new ListaPublicaciones();
        listaRevistas = new ListaPublicaciones();
        listaPeriodicos = new ListaPublicaciones();
        listaSocios = new ListaSocios();
    }

    public void addLibro(Libro libro){
        listaLibros.add(libro);
    }

    public void addRevista(Revista revista){
        listaRevistas.add(revista);
    }

    public void addPeriodico(Periodico periodico){
        listaPeriodicos.add(periodico);
    }

    public void addSocio(Socio socio){
        listaSocios.add(socio);
    }

    public ListaPublicaciones getListaLibros(){
        return listaLibros;
    }

    public ListaPublicaciones getListaRevistas(){
        return listaRevistas;
    }

    public ListaPublicaciones getListaPeriodicos(){
        return listaPeriodicos;
    }

    public ListaSocios getListaSocios(){
        return listaSocios;
    }

    public void prestarLibro(Libro libro, Socio socio){
        Date fechaPrestacion = new Date();
        new Prestamo(socio, fechaPrestacion, null);
        libro.
    }

    @Override
    public String toString() {
        return "Biblioteca{\n" +
                   "\t" + listaLibros + "\n\n" +
                    "\t" + listaRevistas + "\n\n" +
                    "\t" + listaPeriodicos + "\n\n" +
                    "\t" + listaSocios + "\n\n" +
                "}";
    }
}
