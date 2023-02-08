package model;

import model.menu.Opciones;

import java.util.Date;

public class Biblioteca {

    private ListaSE<Libro> listaLibros;
    private ListaSE<Revista> listaRevistas;
    private ListaSE<Periodico> listaPeriodicos;
    private ListaSE<Socio> listaSocios;

    public Biblioteca() {
        listaLibros = new ListaSE<>();
        listaRevistas = new ListaSE<>();
        listaPeriodicos = new ListaSE<>();
        listaSocios = new ListaSE<>();

        Libro l1 = new Libro("El Papel", 348, Color.BLANCOYNEGRO,
                "Antonio Cabanas", "El camino de los dioses", "1122443399441"
                , 5);
        addLibro(l1);

        Libro l2 = new Libro("La Editorial", 280, Color.BLANCOYNEGRO,
                "Miguel de Cervantes Saavedra", "Don Quijote de La Mancha", "4568125946321"
                , 6);
        addLibro(l2);

        addRevista(new Revista("La razón",98, Color.COLOR,
                "El Bienestar", Tematica.SALUD, Periodicidad.SEMANAL, new Date()));

        addPeriodico(new Periodico("ABC", 143, Color.COLOR,
                "El ABC", new Date()));

        Socio s1 = new Socio("Ivan Perez", "48711233H");
        Socio s2 = new Socio("Juan Lopez", "85299963D");
        addSocio(s1);
        addSocio(s2);
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

    public Libro buscarLibro(String titulo){
        int i = 0;
        boolean encontrado = false;
        Libro l = null;

        while(i < listaLibros.getSize() && !encontrado){
            if(titulo.equalsIgnoreCase(listaLibros.get(i).getTitulo())){
                encontrado = true;
                l = listaLibros.get(i);
            }
            i++;
        }
        return l;
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
        int i = 0;

        if(socio.getListaEjemplares().getSize() > 0)
            while (i < libro.getListaEjemplares().getSize() && !encontrado){
                if(libro.getListaEjemplares().contains(socio.getListaEjemplares().get(i))){
                    encontrado = true;
                    socio.getListaEjemplares().get(i).setDisponible(true);
                    socio.removeNumPrestamo();
                }
                i++;
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
