package model;

public class Libro extends Publicacion{

    private String autor;
    private String titulo;
    private int ejemplaresInicial;
    private int ejemplaresDisponibles;
    private String ISBN;
    private String nombrePrestatario = "Sin prestar";

    private final ListaEjemplares listaEjemplares = new ListaEjemplares();

    public Libro(String editorial, int paginas, Color color, String autor, String titulo, String ISBN, int ejemplaresInicial) {
        super(editorial, paginas, color);
        this.autor = autor;
        this.titulo = titulo;
        this.ejemplaresInicial = ejemplaresInicial;
        ejemplaresDisponibles = ejemplaresInicial;
        this.ISBN = ISBN;
        for(int i = 0 ; i <= ejemplaresInicial ; i++)
            listaEjemplares.add(nombrePrestatario);
        Biblioteca.listaLibros.add(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getListaEjemplares(){
        return "Libro '" + titulo + "'{\n\t" + listaEjemplares + "}";
    }

    @Override
    public String toString() {
        return "\tLibro{\n" +
                "\t\tTítulo: " + titulo + "\n" +
                "\t\tAutor: " + autor + "\n" +
                "\t\tEditorial: " + super.getEditorial() + "\n" +
                "\t\tPáginas: " + super.getPaginas() + "\n" +
                "\t\tColor: " + super.getColor() + "\n" +
                "\t\tISBN: " + ISBN + "\n" +
                "\t\tEjemplares disponibles: " + ejemplaresDisponibles + "\n\t}\n";
    }
}
