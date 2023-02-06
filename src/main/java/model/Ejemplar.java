package model;

public class Ejemplar {

    private int codigo;
    private Libro libro;
    private ListaPrestamos listaPrestamos;
    private boolean disponible;

    public Ejemplar(int codigo, Libro libro) {
        this.codigo = codigo;
        this.libro = libro;
        disponible = true;
        listaPrestamos = new ListaPrestamos();
    }

    public int getCodigo() {
        return codigo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public ListaPrestamos getListaPrestamos() {
        return listaPrestamos;
    }

    public void addPrestamo(Prestamo prestamo){
        listaPrestamos.add(prestamo);
    }

    @Override
    public String toString() {
        return "[Código: " + codigo + "  |  ISBN: " + libro.getISBN();

    }
}
