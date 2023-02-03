package model;

public class Libro extends Publicacion{

    private String autor;
    private String titulo;
    private int ejemplaresInicial;
    private String ISBN;
    private String nombrePrestatario = "Disponible";
    private Socio socio = null;
    private final ListaEjemplares listaEjemplares = new ListaEjemplares();

    public Libro(String editorial, int paginas, Color color, String autor, String titulo, String ISBN, int ejemplaresInicial) {
        super(editorial, paginas, color);
        this.autor = autor;
        this.titulo = titulo;
        this.ejemplaresInicial = ejemplaresInicial;
        this.ISBN = ISBN;
        for(int i = 0 ; i <= ejemplaresInicial ; i++)
            listaEjemplares.add(socio);
        Biblioteca.listaLibros.add(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public String printListaEjemplares(){
        return "Libro '" + titulo + "'{\n\t" + listaEjemplares + "}";
    }

    public ListaEjemplares getListaEjemplares(){
        return listaEjemplares;
    }

    public void setNombrePrestatario(String nombrePrestatario){
        this.nombrePrestatario = nombrePrestatario;
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
                "\t\tEjemplares disponibles: " + listaEjemplares.getTotalDisponibles() + "\n\t}\n";
    }
}
