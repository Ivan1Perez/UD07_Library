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
        return "Revista\n" +
                "Nombre: " + nombre + "\n" +
                "Editorial: " + super.getEditorial() + "\n" +
                "Temática: " + tematica + "\n" +
                "Periodicidad: " + periodicidad + "\n" +
                "Páginas: " + super.getPaginas() + "\n" +
                "Color: " + super.getColor() + "\n";
    }
}
