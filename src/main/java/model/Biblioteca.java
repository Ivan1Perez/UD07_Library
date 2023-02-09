package model;

import java.util.Date;

public class Biblioteca {

    private ListaSE<Libro> listaLibros;
    private ListaSE<Revista> listaRevistas;
    private ListaSE<Periodico> listaPeriodicos;
    private ListaSE<Socio> listaSocios;
    private String confirmacion;
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

    public Libro buscarLibro(String titulo){
        int i = 0;
        boolean encontrado = false;
        Libro l = null;

        while(i < listaLibros.getSize() && !encontrado){
            if(listaLibros.get(i).getTitulo().toLowerCase().contains(titulo.toLowerCase())){
                encontrado = true;
                l = listaLibros.get(i);
            }
            i++;
        }

        if(!encontrado)
            confirmacion = Confirmacion.TITLE_NOTFOUND.getRespuesta();
        else confirmacion = "";

        return l;
    }

    public Socio buscarSocio(String DNI){
        int i = 0;
        boolean encontrado = false;
        Socio s = null;

        while(i < listaSocios.getSize() && !encontrado){
            if(listaSocios.get(i).getDNI().equalsIgnoreCase(DNI.toLowerCase())){
                encontrado = true;
                s = listaSocios.get(i);
            }
            i++;
        }

        if(!encontrado)
            confirmacion = Confirmacion.DNI_NOTFOUND.getRespuesta();
        else confirmacion = "";

        return s;
    }

    public boolean prestarLibro() {
        int i = 0;
        boolean prestamoCorrecto = false;
        boolean libroCorrecto = false;

        Libro l;
        Socio s;

        do {
            l = buscarLibro(entrada.titulo());
            if (entrada.libroBuscado(l))
                libroCorrecto = true;
        } while (!libroCorrecto);

        do {
            s = buscarSocio(entrada.DNI());
            if(s==null){
                if(entrada.opcionesDNI()==2){
                    addSocio(entrada.crearSocio(listaSocios));
                }
            }

        }while(s==null);

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

    public boolean devolverLibro(String titulo, String DNI){
        boolean encontrado = false;
        int i = 0;

        Libro l = buscarLibro(titulo);
        Socio s = buscarSocio(DNI);

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
