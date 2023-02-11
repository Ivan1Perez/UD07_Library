package model;

import java.util.Date;

public class Biblioteca<T> {

    private ListaSE<Libro> listaLibros;
    private ListaSE<Revista> listaRevistas;
    private ListaSE<Periodico> listaPeriodicos;
    private ListaSE<Socio> listaSocios;
    private String confirmacion = "";
    private Entrada entrada = new Entrada();

    public Biblioteca() {
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

    public String getConfirmacion() {
        return confirmacion;
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

    public ListaSE<Prestamo> getListaPrestamosLibro(){
        ListaSE<Prestamo> listaPrestamos = null;
        Libro l = checkLibro();
        int i = 0, codEjemplar;

        do {
            codEjemplar = entrada.checkCodEjemplar();

            if (codEjemplar <= l.getListaEjemplares().getSize()) {
                while (i < l.getListaEjemplares().getSize() && listaPrestamos == null) {
                    if (codEjemplar == l.getListaEjemplares().get(i).getCodigo()) {
                        listaPrestamos = l.getListaEjemplares().get(i).getListaPrestamos();
                    }
                    i++;
                }
            }
            if (listaPrestamos == null)
                i = 0;
        } while (listaPrestamos == null);


        return listaPrestamos;
    }

    public ListaSE<Prestamo<Ejemplar>> getListaPrestamosSocio(){
        Socio s = checkSocio();
        return s.getListaPrestamos();

    }

    public Libro buscarLibro(){
        int i;
        boolean encontrado = false;
        String titulo;
        Libro l = null;

        do {
            i = 0;
            titulo = entrada.titulo();
            while (i < listaLibros.getSize() && !encontrado) {
                if (listaLibros.get(i).getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                    encontrado = true;
                    l = listaLibros.get(i);
                }
                i++;
            }

            if (!encontrado)
                entrada.tituloNoCoincide();
        }while(!encontrado);

        return l;
    }

    public Socio buscarSocio(){
        int i;
        boolean encontrado = false;
        Socio s = null;
        String DNI;

        do {
            DNI = entrada.DNI();
            i = 0;
            while (i < listaSocios.getSize() && !encontrado) {
                if (listaSocios.get(i).getDNI().equalsIgnoreCase(DNI.toLowerCase())) {
                    encontrado = true;
                    s = listaSocios.get(i);
                }
                i++;
            }
            if (!encontrado)
                if(entrada.DNI_NoEncontrado()==2)
                    encontrado = true;
        }while(!encontrado);

        return s;
    }

    public Libro checkLibro(){
        boolean libroCorrecto = false;
        Libro l;

        do {
            l = buscarLibro();
            if(l==null)
                entrada.tituloNoCoincide();
            else if (entrada.libroBuscado(l))
                libroCorrecto = true;
        } while (!libroCorrecto);

        return l;
    }

    public Socio checkSocio(){
        Socio s;

        do {
            s = buscarSocio();
            if(s==null)
                addSocio(entrada.crearSocio(listaSocios));
        }while(s==null);

        return s;
    }

    public boolean prestarLibro() {
        int i = 0;
        boolean prestamoCorrecto = false, socioMaxPrestamos = false;
        Libro l = checkLibro();
        Socio s = checkSocio();
        Ejemplar ejemplar;
//        T tipo = (T) s;

        if(s.getNumPrestamos()==3)
            socioMaxPrestamos = true;
        else{
            while (i < l.getListaEjemplares().getSize() && !prestamoCorrecto) {
                if (l.getListaEjemplares().get(i).isDisponible()) {
                    prestamoCorrecto = true;
                    ejemplar = l.getListaEjemplares().get(i);
                    ejemplar.setDisponible(false);
                    ejemplar.addPrestamo(new Prestamo<>(s));
                    s.addNumPrestamos();
                    s.addEjemplar(ejemplar);
                    s.addPrestamo(new Prestamo<>(ejemplar));
                }
                i++;
            }
        }

        if (prestamoCorrecto)
            confirmacion = Confirmacion.LOAN_DONE.getRespuesta();
        else {
            if (socioMaxPrestamos)
                confirmacion = Confirmacion.LOAN_NOTDONE1.getRespuesta();
            else
                confirmacion = Confirmacion.LOAN_NOTDONE2.getRespuesta();
        }
        return prestamoCorrecto;
    }

    public boolean devolverLibro(){
        boolean confirmado = false, socioSinPrestamos = false;
        int i = 0;
        Prestamo prestamoSocio;
        Ejemplar ejemplarLibro = null;
        Ejemplar ejemplar;

        Libro l = checkLibro();
        Socio s = checkSocio();

        if(s.getNumPrestamos() == 0)
            socioSinPrestamos = true;

        if(!socioSinPrestamos){
            while (i < s.getListaPrestamos().getSize() && !confirmado){
                if(l.getListaEjemplares().contains(s.getListaPrestamos().get(i).getTipo())){
                    prestamoSocio = s.getListaPrestamos().get(i);
                    ejemplar = s.getListaPrestamos().get(i).getTipo();
                    if(prestamoSocio.getDevuelto()==null) {
                        confirmado = true;
                        ejemplarLibro = l.getListaEjemplares().containsElement(ejemplar);
                        prestamoSocio.setDevuelto(new Date());
                        ejemplar.setDisponible(true);
                        s.removeNumPrestamo();
                    }
                }
                i++;
            }

        }

        i = 0;

        if(confirmado) {
            while(i < ejemplarLibro.getListaPrestamos().getSize()){
                if(ejemplarLibro.getListaPrestamos().get(i).getDevuelto()==null)
                    ejemplarLibro.getListaPrestamos().get(i).setDevuelto(new Date());
                i++;
            }
            confirmacion = Confirmacion.RETURN_DONE.getRespuesta();

        }
        else{
            if(socioSinPrestamos)
                confirmacion = Confirmacion.RETURN_NOTDONE1.getRespuesta();
            else
                confirmacion = Confirmacion.RETURN_NOTDONE2.getRespuesta();
        }

        return confirmado;
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
