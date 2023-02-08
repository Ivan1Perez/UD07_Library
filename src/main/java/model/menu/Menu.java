package model.menu;

import model.Biblioteca;
import model.Entrada;
import model.Libro;
import model.ListaSE;
import org.w3c.dom.ls.LSOutput;

public class Menu {

    private String mensajeInicio = "Bienvenido a la Biblioteca";
    private Opciones opciones = new Opciones();
    private Entrada entrada = new Entrada();
    private Biblioteca biblioteca;
    private ListaSE listaSE;
    private Libro libro;
    private boolean prestado;
    private boolean devuelto;
    private int opcionSelecionada;

    public Menu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getMensajeInicio() {
        return mensajeInicio;
    }

    public String[] opcionesIniciales(){
        return opciones.opcionesIniciales();
    }

    public String[] opcionesTotales() {
        return opciones.opcionesTotales();
    }

    public <T> T selecOpcionesIniciales() {
        T result = null;

        switch (entrada.selecOpcionesIniciales()){
            case 1:
                opcionSelecionada = 1;
                this.libro = biblioteca.buscarLibro(entrada.texto());
                result = (T) libro;
                break;
            case 2:
                opcionSelecionada = 2;
                this.prestado = biblioteca.prestarLibro(biblioteca.getListaLibros().get(0), biblioteca.getListaSocios().get(0));
                if(prestado)
                    result = (T) Boolean.TRUE;
                else
                    result = (T) Boolean.FALSE;
                break;
            case 3:
                opcionSelecionada = 3;
                this.devuelto = biblioteca.devolverLibro(biblioteca.getListaLibros().get(0), biblioteca.getListaSocios().get(0));
                if(devuelto)
                    result = (T) Boolean.TRUE;
                else
                    result = (T) Boolean.FALSE;
                break;
            case 4:
                opcionSelecionada = 4;
                break;
            case 5:
                opcionSelecionada = 5;
                break;
        }

        return result;
    }

    public void selecOpcionesTotales() {

        switch (entrada.selecOpcionesTotales()){
            case 1:
                this.listaSE = biblioteca.getListaLibros();
                break;
            case 2:
                this.listaSE = biblioteca.getListaRevistas();
                break;
            case 3:
                this.listaSE = biblioteca.getListaPeriodicos();
                break;
            case 4:
                this.listaSE = biblioteca.getListaSocios();
                break;
        }
    }

    public int getOpcionSelecionada() {
        return opcionSelecionada;
    }

    public Libro getLibro() {
        return libro;
    }

    public ListaSE getListaSE() {
        return listaSE;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public boolean isDevuelto() {
        return devuelto;
    }
}
