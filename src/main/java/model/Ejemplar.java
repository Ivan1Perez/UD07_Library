package model;

public class Ejemplar {

    private int codigo;
    private Libro libro;
    private ListaPrestamos prestamos;

    public Ejemplar(int codigo, Libro libro) {
        this.codigo = codigo;
        this.libro = libro;
    }
}
