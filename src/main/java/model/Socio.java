package model;

public class Socio{

    private String nombre;
    private String DNI;
    private ListaSE<Ejemplar> listaEjemplares;
    private ListaSE<Prestamo<Ejemplar>> listaPrestamos;
    private int numPrestamos;
    private boolean alta;


    public Socio(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        listaEjemplares = new ListaSE<>();
        listaPrestamos = new ListaSE<>();
        alta = true;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public ListaSE<Prestamo<Ejemplar>> getListaPrestamos() {
        return listaPrestamos;
    }

    public void addEjemplar(Ejemplar ejemplar){
        listaEjemplares.add(ejemplar);
    }

    public void addNumPrestamos(){
        numPrestamos++;
    }

    public void removeNumPrestamo(){
        numPrestamos--;
    }

    public void addPrestamo(Prestamo prestamo){
        listaPrestamos.add(prestamo);
    }

    public int getNumPrestamos() {
        return numPrestamos;
    }

    public ListaSE<Ejemplar> getListaEjemplares() {
        return listaEjemplares;
    }

    @Override
    public String toString() {
        return "\t\t[Nombre: " + nombre + "   |   DNI: " + DNI + "   |   " +
                "Préstamos realizados: " + listaEjemplares.getSize() + "   |   " +
                "Libros por devolver: " + numPrestamos + "]";
    }

}
