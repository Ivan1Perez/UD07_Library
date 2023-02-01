package model;

public class Revista extends Publicacion{

    private String nombre;
    private Tematica tematica;
    private Periodicidad periodicidad;
    private final int ejemplar = 1;

    public Revista(String editorial, int paginas, Color color, String nombre, Tematica tematica, Periodicidad periodicidad) {
        super(editorial, paginas, color);
        this.nombre = nombre;
        this.tematica = tematica;
        this.periodicidad = periodicidad;
    }

    @Override
    public String toString() {
        return "\tRevista{\n" +
                "\t\tNombre: " + nombre + "\n" +
                "\t\tEditorial: " + super.getEditorial() + "\n" +
                "\t\tTemática: " + tematica + "\n" +
                "\t\tPeriodicidad: " + periodicidad + "\n" +
                "\t\tPáginas: " + super.getPaginas() + "\n" +
                "\t\tColor: " + super.getColor() + "\n\t}\n";
    }
}
