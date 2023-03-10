package model;

public class Libro extends Publicacion<Libro>{

    private String autor;
    private String titulo;
    private int ejemplaresInicial;
    private String ISBN;
    protected ListaSE<Ejemplar> listaEjemplares = new ListaSE<>();
    private Object tipo;

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

    public ListaSE<Ejemplar> getListaEjemplares(){
        return listaEjemplares;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getEjemplaresDisponibles(){
        int i = 0;
        int total = 0;

        while(i < listaEjemplares.getSize()){
            if(listaEjemplares.get(i).isDisponible())
                total++;
            i++;
        }

        return total;
    }

    public Object getTipo() {
        return this;
    }

    @Override
    public String toString() {
        return "\t\tTítulo: " + titulo + "\n" +
                "\t\tAutor: " + autor + "\n" +
                "\t\tEditorial: " + super.getEditorial() + "\n" +
                "\t\tPáginas: " + super.getPaginas() + "\n" +
                "\t\tColor: " + super.getColor() + "\n" +
                "\t\tISBN: " + ISBN + "\n" +
                "\t\tEjemplares disponibles: " + getEjemplaresDisponibles() + "\n";
    }
}
