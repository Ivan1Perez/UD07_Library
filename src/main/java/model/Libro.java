package model;

public class Libro extends Publicacion{

    private String autor;
    private String titulo;
    private int ISBN;
    private int ejemplaresInicial;
    private int ejemplaresActuales;

//    private Lista libro = new Lista();

    public Libro(String editorial, int paginas, Color color, String autor, String titulo, int ISBN, int ejemplaresInicial) {
        super(editorial, paginas, color);
        this.autor = autor;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.ejemplaresInicial = ejemplaresInicial;
    }

    public boolean prestamo(String titulo){
        if(titulo.equalsIgnoreCase(this.titulo) && ejemplaresActuales > 0){


            return true;
        }


    }

    @Override
    public String toString() {
        return "Libro\n" +
                "Autor: " + autor + "\n" +
                "Título: " + titulo + "\n" +
                "Editorial: " + super.getEditorial() + "\n" +
                "Páginas: " + super.getPaginas() + "\n" +
                "Color: " + super.getColor() + "\n" +
                "ISBN: " + ISBN + "\n" +
                "Ejemplares: " + ejemplaresInicial + "\n";
    }
}