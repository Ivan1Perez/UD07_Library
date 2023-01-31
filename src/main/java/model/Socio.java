package model;

public class Socio {

    private String nombre;
    private String DNI;
    private Lista lista;

    public Socio(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Socio\n" +
                "Nombre: " + nombre + "\n" +
                "DNI: " + DNI + "\n" +
                "Libros prestados: " + lista;
    }
}
