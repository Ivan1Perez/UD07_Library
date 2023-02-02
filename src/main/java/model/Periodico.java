package model;

public class Periodico extends Publicacion{

    private String nombre;
    private String fechaPublicacion;
    private final int ejemplar = 1;


    public Periodico(String editorial, int paginas, Color color, String nombre, String fechaPublicacion) {
        super(editorial, paginas, color);
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
        Biblioteca.listaPeriodicos.add(this);
    }

    @Override
    public String toString() {
        return "\tPeriódico{\n" +
                "\t\tNombre: " + nombre + "\n" +
                "\t\tEditorial: " + super.getEditorial() + "\n" +
                "\t\tPáginas: " + super.getPaginas() + "\n" +
                "\t\tColor: " + super.getColor() + "\n" +
                "\t\tFecha de publicación: " + fechaPublicacion + "\n\t}\n";
    }
}
