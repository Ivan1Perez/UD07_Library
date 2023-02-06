package model;

public class Ejemplar {

    private int codigo;
    private Libro libro;
    private ListaSE<Prestamo> listaPrestamos;
    private boolean disponible;

    public Ejemplar(int codigo, Libro libro) {
        this.codigo = codigo;
        this.libro = libro;
        disponible = true;
        listaPrestamos = new ListaSE<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getTitulo(){
        return libro.getTitulo();
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public ListaSE<Prestamo> getListaPrestamos() {
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
