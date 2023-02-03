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

    public ListaLibros getListaLibros(){
        return listaLibros;
    }

    public ListaRevistas getListaRevistas(){
        return listaRevistas;
    }

    public ListaPeriodicos getListaPeriodicos(){
        return listaPeriodicos;
    }

    public ListaSocios getListaSocios(){
        return listaSocios;
    }

    public boolean prestamo(String titulo, Socio socio){
        if(listaLibros.getLibro(titulo,socio)) {// && DNI.equalsIgnoreCase(listaSocios.getDNI()))
            if(socio.getEjemplaresPrestados() < 3){
                socio.prestamoObtenido();
                return true;
            }else
                System.out.println("Lo sentimos, un socio no puede tener más de 3 ejemplares");
        }else
            System.out.println("El libro '" + titulo + "'no se encuentra en esta biblioteca.");
        return false;
    }

}
