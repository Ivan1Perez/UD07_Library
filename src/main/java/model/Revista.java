package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Revista extends Publicacion{

    private String nombre;
    private Tematica tematica;
    private Periodicidad periodicidad;
    private final int ejemplar = 1;
    private Date fechaPublicacion;

    public Revista(String editorial, int paginas, Color color, String nombre, Tematica tematica,
                   Periodicidad periodicidad, Date fechaPublicacion) {
        super(editorial, paginas, color);
        this.nombre = nombre;
        this.tematica = tematica;
        this.periodicidad = periodicidad;
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "\t\tNombre: " + nombre + "\n" +
                "\t\tEditorial: " + super.getEditorial() + "\n" +
                "\t\tTemática: " + tematica + "\n" +
                "\t\tPeriodicidad: " + periodicidad + "\n" +
                "\t\tPáginas: " + super.getPaginas() + "\n" +
                "\t\tColor: " + super.getColor() + "\n" +
                "\t\tFecha de publicación: " + formatter.format(fechaPublicacion);
    }
}
