package model;

public class Socio{

    private String nombre;
    private String DNI;
    private ListaSE<Ejemplar> listaEjemplares;
    private int numPrestamos;

    public Socio(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        listaEjemplares = new ListaSE<>();
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

    public int getNumPrestamos() {
        return numPrestamos;
    }

    public String printListaEjemplares(){
        return "[Nombre: " + nombre + "   |   DNI: " + DNI + "]{\n" +
                "\t" + listaEjemplares + "\n}";
    }

    public ListaSE<Ejemplar> getListaEjemplares() {
        return listaEjemplares;
    }

    public int getEjemplaresPrestados() {
        return listaEjemplares.getSize();
    }

    @Override
    public String toString() {
        return "\t[Nombre: " + nombre + "   |   DNI: " + DNI + "   |   Libros prestados: " + numPrestamos + "]";
    }

}
