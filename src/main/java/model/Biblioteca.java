package model;

import java.util.Date;

public class Biblioteca {

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

        Libro l1 = new Libro("El Papel", 348, Color.BLANCOYNEGRO,
                "Antonio Cabanas", "El camino de los dioses", "1122443399441"
                , 5);
        addLibro(l1);

        Libro l2 = new Libro("La Editorial", 280, Color.BLANCOYNEGRO,
                "Miguel de Cervantes Saavedra", "Don Quijote de La Mancha", "4568125946321"
                , 6);
        addLibro(l2);

        addLibro(new Libro("La Editorial", 350, Color.BLANCOYNEGRO,
                "Jane Austen", "Orgullo y Prejuicio", "8521457956321"
                , 7));

        addLibro(new Libro("Mesón", 430, Color.BLANCOYNEGRO,
                "Fyodor Dostoevsky", "Crimen y Castigo", "6541254896321"
                , 9));

        addLibro(new Libro("Burgos Editores", 240, Color.BLANCOYNEGRO,
                "Mark Twain", "Las Aventuras de Tom Sawyer", "1235465478921"
                , 5));

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

    public ListaSE<Prestamo> getListaPrestamos(){
        ListaSE<Prestamo> listaPrestamos = null;
        Libro l = checkLibro();
        int i = 0, codEjemplar;

        do{
            codEjemplar = entrada.checkCodEjemplar();

            if(codEjemplar <= l.getListaEjemplares().getSize()){
                while(i < l.getListaEjemplares().getSize() && listaPrestamos==null) {
                    if (codEjemplar == l.getListaEjemplares().get(i).getCodigo()) {
                        listaPrestamos = l.getListaEjemplares().get(i).getListaPrestamos();
                    }
                    i++;
                }
            }
            if(listaPrestamos==null)
                i = 0;
        }while(listaPrestamos==null);

        return listaPrestamos;
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
        boolean prestamoCorrecto = false;
        Libro l = checkLibro();
        Socio s = checkSocio();

        while (i < l.getListaEjemplares().getSize() && !prestamoCorrecto) {
            if (l.getListaEjemplares().get(i).isDisponible() && s.getNumPrestamos() < 3) {
                prestamoCorrecto = true;
                l.getListaEjemplares().get(i).setDisponible(false);
                l.getListaEjemplares().get(i).addPrestamo(new Prestamo(s, new Date(), null));
                s.addNumPrestamos();
                s.addEjemplar(l.getListaEjemplares().get(i));
            }
            i++;
        }

        if (prestamoCorrecto)
            confirmacion = Confirmacion.LOAN_DONE.getRespuesta();
        else confirmacion = Confirmacion.LOAN_NOTDONE.getRespuesta();

        return prestamoCorrecto;
    }

    public boolean devolverLibro(){
        boolean encontrado = false;
        int i = 0;
        int tamañoLista;

        Libro l = checkLibro();
        Socio s = checkSocio();

        if(l==null)
            confirmacion = Confirmacion.TITLE_NOTFOUND.getRespuesta();
        else if(s==null)
            confirmacion = Confirmacion.DNI_NOTFOUND.getRespuesta();
        else{
            if(s.getListaEjemplares().getSize() > 0)
                while (i < l.getListaEjemplares().getSize() && !encontrado){
                    if(l.getListaEjemplares().contains(s.getListaEjemplares().get(i))){
                        encontrado = true;
                        s.getListaEjemplares().get(i).setDisponible(true);
                        tamañoLista = s.getListaEjemplares().get(i).getListaPrestamos().getSize();
//                        ----------------------------------------------------------------------
//                        ESTA LINEA NO ES CORRECTA
//                        SE HA DE COMPROBAR QUE EL PRESTAMO DEL EJEMPLAR ES EL MISMO QUE EL PRESTAMO A DEVOLVER
                        s.getListaEjemplares().get(i).getListaPrestamos().get(tamañoLista-1).setDevuelto(new Date());
//                        ----------------------------------------------------------------------
                        s.removeNumPrestamo();
                    }
                    i++;
                }
        }

        if(encontrado)
            confirmacion = Confirmacion.RETURN_DONE.getRespuesta();
        else if(l != null && s != null) confirmacion = Confirmacion.RETURN_NOTDONE.getRespuesta();



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
