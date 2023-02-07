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

    public boolean prestarLibro(Libro libro, Socio socio){
        int i = 0;
        boolean disponible = false;
        while(i < libro.getListaEjemplares().getSize() && !disponible) {
            if (libro.getListaEjemplares().get(i).isDisponible() && socio.getNumPrestamos() < 3){
                disponible = true;
                libro.getListaEjemplares().get(i).setDisponible(false);
                libro.getListaEjemplares().get(i).addPrestamo(new Prestamo(socio, new Date(), null));
                socio.addNumPrestamos();
                socio.addEjemplar(libro.getListaEjemplares().get(i));
            }
            i++;
        }
        return disponible;
    }

    public boolean devolverLibro(Libro libro, Socio socio){
        boolean encontrado = false;
        int i = 0, k = 0;

            while (k < libro.getListaEjemplares().getSize() && !libro.getListaEjemplares().contains(socio.getListaEjemplares().get(k))){
                if(!libro.getListaEjemplares().contains(socio.getListaEjemplares().get(k)))
                    encontrado = true;
                k++;
            }

        return encontrado;
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
