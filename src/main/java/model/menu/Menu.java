package model.menu;

import model.Biblioteca;
import model.Entrada;
import model.Libro;
import model.ListaSE;

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

    public void selecOpcionesPrincipales() {

        switch (entrada.checkOpcionesPrincipales()){
            case 1:
                opcionSelecionada = 1;
                this.libro = biblioteca.checkLibro();
                break;
            case 2:
                opcionSelecionada = 2;
                this.prestado = biblioteca.prestarLibro();
                break;
            case 3:
                opcionSelecionada = 3;
                this.devuelto = biblioteca.devolverLibro();
                break;
            case 4:
                opcionSelecionada = 4;
                break;
            case 5:
                opcionSelecionada = 5;
                break;
        }
    }

    public void selecMasOpciones() {

        switch (entrada.checkMasOpciones()){
            case 1:
                opcionSelecionada = 1;
                this.listaSE = biblioteca.getListaLibros();
                break;
            case 2:
                opcionSelecionada = 2;
                this.listaSE = biblioteca.getListaRevistas();
                break;
            case 3:
                opcionSelecionada = 3;
                this.listaSE = biblioteca.getListaPeriodicos();
                break;
            case 4:
                opcionSelecionada = 4;
                this.listaSE = biblioteca.getListaSocios();
                break;
            case 5:
                opcionSelecionada = 5;
                break;
            case 6:
                opcionSelecionada = 6;
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
