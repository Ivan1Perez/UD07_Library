package model;

public class Periodico extends Publicacion{

    private String nombre;
    private String fechaPublicacion;
    private final int ejemplar = 1;


    public Periodico(String editorial, int paginas, Color color, String nombre, String fechaPublicacion) {
        super(editorial, paginas, color);
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Periódico\n" +
                "Nombre: " + nombre + "\n" +
                "Editorial: " + super.getEditorial() + "\n" +
                "Páginas: " + super.getPaginas() + "\n" +
                "Color: " + super.getColor() + "\n" +
                "Fecha de publicación: " + fechaPublicacion;
    }
}
