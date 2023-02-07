package model;

public class Libro extends Publicacion{

    private String autor;
    private String titulo;
    private int ejemplaresInicial;
    private String ISBN;
    protected ListaSE<Ejemplar> listaEjemplares = new ListaSE<>();

    public Libro(String editorial, int paginas, Color color, String autor, String titulo, String ISBN, int ejemplaresInicial) {
        super(editorial, paginas, color);
        this.autor = autor;
        this.titulo = titulo;
        this.ejemplaresInicial = ejemplaresInicial;
        this.ISBN = ISBN;
        for(int i = 1 ; i <= ejemplaresInicial ; i++)
            listaEjemplares.add(new Ejemplar(i, this));
    }

    public String getTitulo() {
        return titulo;
    }

    public String printListaEjemplares(){
        return "Libro '" + titulo + "'{\n\t" + listaEjemplares + "}";
    }

    public ListaSE<Ejemplar> getListaEjemplares(){
        return listaEjemplares;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "\t\tTítulo: " + titulo + "\n" +
                "\t\tAutor: " + autor + "\n" +
                "\t\tEditorial: " + super.getEditorial() + "\n" +
                "\t\tPáginas: " + super.getPaginas() + "\n" +
                "\t\tColor: " + super.getColor() + "\n" +
                "\t\tISBN: " + ISBN + "\n" +
                "\t\tEjemplares disponibles: " + ejemplaresInicial + "\n";
    }
}
