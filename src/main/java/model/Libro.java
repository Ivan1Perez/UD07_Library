package model;

public class Libro extends Publicacion{

    private String autor;
    private String titulo;
    private long ISBN;
    private int ejemplaresInicial;
    private int ejemplaresDisponibles;

    private static final ListaLibro listaLibro = new ListaLibro();

    public Libro(String editorial, int paginas, Color color, String autor, String titulo, int ejemplaresInicial) {
        super(editorial, paginas, color);
        this.autor = autor;
        this.titulo = titulo;
        String numISBN = "";
        for(int i = 0 ; i < 13 ; i++){
            numISBN += String.valueOf((int) (Math.random()*(9+1)));
        }
        this.ISBN = Long.parseLong(numISBN);
        this.ejemplaresInicial = ejemplaresInicial;
        ejemplaresDisponibles = ejemplaresInicial;
        listaLibro.add(this);
    }

    public boolean prestamo(String titulo){
        if(ejemplaresDisponibles > 0 && listaLibro.getTitulo(titulo)){
            ejemplaresDisponibles--;
            return true;
        }

        return false;
    }

//    public void actualizarEjemplares(int cantidad){
//        listaLibro.ge
//    }

    public String getTitulo() {
        return titulo;
    }


    public ListaLibro getListaLibro(){
        return listaLibro;
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
