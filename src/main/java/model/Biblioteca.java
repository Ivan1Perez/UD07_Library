package model;

import model.menu.OpcionesIniciales;

import java.util.Date;

public class Biblioteca {

    private OpcionesIniciales opcionesIniciales;
    private Entrada entrada;
    private Libro libro;
    private ListaSE<Libro> listaLibros;
    private ListaSE<Revista> listaRevistas;
    private ListaSE<Periodico> listaPeriodicos;
    private ListaSE<Socio> listaSocios;

    public Biblioteca() {
//        System.out.println(opcionesIniciales = new OpcionesIniciales());
//        new Entrada();

        listaLibros = new ListaSE<>();
        listaRevistas = new ListaSE<>();
        listaPeriodicos = new ListaSE<>();
        listaSocios = new ListaSE<>();
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

    public ListaSE<Libro> getListaLibros(){
        return listaLibros;
    }

    public ListaSE<Revista> getListaRevistas(){
        return listaRevistas;
    }

    public ListaSE<Periodico> getListaPeriodicos(){
        return listaPeriodicos;
    }

    public ListaSE<Socio> getListaSocios(){
        return listaSocios;
    }

//    public boolean prestarLibro(Libro libro, Socio socio){
//        boolean prestamoRealizado = false;
//
//        if(libro.getListaEjemplares().disponible(new Prestamo(socio, new Date(), null))){
//            socio.addNumPrestamos();
//            prestamoRealizado = true;
//        }
//        return prestamoRealizado;
//    }
//
//    public boolean devolverLibro(Libro libro, Socio socio){
//        boolean devolucionRealizada = false;
//        int posicion = 0;
//
//
//        while(posicion < libro.getListaEjemplares().getSize() && !devolucionRealizada){
//            if(libro.getListaEjemplares().get(posicion).equals(socio.getListaEjemplares().get(posicion))
//                && !libro.getListaEjemplares().get(posicion).isDisponible()){
//                    //Sobreescribir método equals???
//                libro.getListaEjemplares().get(posicion).setDisponible(true);
//                libro.getListaEjemplares().get(posicion).getListaPrestamos().
//                        get(libro.getListaEjemplares().get(posicion).getListaPrestamos().getSize()-1).setDevuelto(new Date());
////                socio.getListaEjemplares().get(posicion).setDisponible(true);
//                socio.removeNumPrestamo();
//                devolucionRealizada = true;
//            }
//            posicion++;
//        }
//
//        return devolucionRealizada;
//    }


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
