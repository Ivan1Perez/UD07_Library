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
                if (listaLibros.get(i).getTitulo().toLowerCase().contains(titulo.toLowerCase()) &&
                        listaLibros.get(i).isAlta()) {
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

        do{
            l = buscarLibro();
            if(entrada.busquedaPublicacion(l))
                libroCorrecto = true;
        }while(!libroCorrecto);


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

    public boolean altaPublicacion(){
        boolean altaCorrecta = false;

        Publicacion p = buscarPublicacion();

        if(!p.isAlta()){
            altaCorrecta = true;
            p.setAlta(true);
        }


        return altaCorrecta;
    }

    public boolean bajaPublicacion(){
        boolean bajaCorrecta = false;

        Publicacion p = buscarPublicacion();

        if(p.isAlta()){
            bajaCorrecta = true;
            p.setAlta(false);
        }

        return bajaCorrecta;
    }

    public Publicacion buscarPublicacion(){
        int i;
        boolean encontrado = false;
        String titulo;
        Publicacion p = null;
        ListaSE listaPublicaciones = listaLibros;
        listaPublicaciones.addAll(listaRevistas);
        listaPublicaciones.addAll(listaPeriodicos);


        do {
            i = 0;
            titulo = entrada.tituloPublicacion();
            while (i < listaPublicaciones.getSize() && !encontrado) {
                if (listaPublicaciones.get(i).toString().toLowerCase().contains(titulo.toLowerCase())) {
                    Object obj = listaPublicaciones.get(i);
                    if(obj instanceof Libro)
                        p = (Libro) obj;
                    else if(obj instanceof Revista)
                        p = (Revista) obj;
                    else
                        p = (Periodico) obj;

                    if(entrada.busquedaPublicacion(p))
                        encontrado = true;

                }
                i++;
            }

            if (!encontrado)
                entrada.tituloNoCoincide();
        }while(!encontrado);

        return p;
    }

    public boolean altaSocio(){
        boolean altaCorrecta = false;

        Socio s = checkSocio();

        if(!s.isAlta()){
            altaCorrecta = true;
            s.setAlta(true);
        }


        return altaCorrecta;
    }

    public boolean bajaSocio(){
        boolean bajaCorrecta = false;

        Socio s = checkSocio();

        if(s.isAlta()){
            bajaCorrecta = true;
            s.setAlta(false);
        }

        return bajaCorrecta;
    }

    public void modificarSocio(){
        Socio s;
        int opcion = entrada.opciones1_2();

        if(opcion==1) {
            s = checkSocio();
            s.setNombre(entrada.nombre());
        }
        else{
            s = checkSocio();
            s.setDNI(entrada.checkNewDNI(listaSocios));
        }

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
