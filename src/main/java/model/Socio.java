package model;

public class Socio{

    private String nombre;
    private String DNI;
    private ListaEjemplares listaEjemplares;

    public Socio(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        listaEjemplares = new ListaEjemplares();
    }

    public void addEjemplar(Ejemplar ejemplar){
        listaEjemplares.add(ejemplar);
    }

    public ListaEjemplares getListaEjemplares() {
        return listaEjemplares;
    }

    public int getEjemplaresPrestados() {
        return listaEjemplares.getSize();
    }

    @Override
    public String toString() {
        return "\t[Nombre: " + nombre + "   |   DNI: " + DNI + "   |   Libros prestados: " + getEjemplaresPrestados() + "]";
    }

}
