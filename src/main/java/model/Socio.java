package model;

public class Socio{

    private String nombre;
    private String DNI;
    private ListaEjemplares librosPrestados;

    public Socio(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        Biblioteca.listaSocios.add(this);
    }

    @Override
    public String toString() {
        return "\tSocio{\n" +
                "\t\tNombre: " + nombre + "\n" +
                "\t\tDNI: " + DNI + "\n" +
                "\t\tLibros prestados: " + librosPrestados + "\n" +
                "\t}\n";
    }
}
