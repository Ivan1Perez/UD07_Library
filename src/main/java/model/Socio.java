package model;

public class Socio{

    private String nombre;
    private String DNI;
    private int ejemplaresPrestados;

    public Socio(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        Biblioteca.listaSocios.add(this);
    }

    public void prestamoObtenido(){
        this.ejemplaresPrestados++;
    }

    public int getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    @Override
    public String toString() {
        return "\t[Nombre: " + nombre + "\tDNI: " + DNI + "\tLibros prestados: " + ejemplaresPrestados + "]";
    }
}
