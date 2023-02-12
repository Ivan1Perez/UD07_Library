package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Periodico extends Publicacion{

    private String nombre;
    private final int ejemplar = 1;
    private Date fechaPublicacion;


    public Periodico(String editorial, int paginas, Color color, String nombre, Date fechaPublicacion) {
        super(editorial, paginas, color);
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTitulo(){
        return nombre;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "\t\tNombre: " + nombre + "\n" +
                "\t\tEditorial: " + super.getEditorial() + "\n" +
                "\t\tPáginas: " + super.getPaginas() + "\n" +
                "\t\tColor: " + super.getColor() + "\n" +
                "\t\tFecha de publicación: " + formatter.format(fechaPublicacion) + "\n";
    }
}
