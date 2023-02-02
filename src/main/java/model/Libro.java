package model;

public class Libro extends Publicacion{

    private String autor;
    private String titulo;
    private int ejemplaresInicial;
    private int ejemplaresDisponibles;

    private final ListaEjemplares listaEjemplares = new ListaEjemplares();

    public Libro(String editorial, int paginas, Color color, String autor, String titulo, int ejemplaresInicial) {
        super(editorial, paginas, color);
        this.autor = autor;
        this.titulo = titulo;
        this.ejemplaresInicial = ejemplaresInicial;
        ejemplaresDisponibles = ejemplaresInicial;
        for(int i = 0 ; i < ejemplaresInicial ; i++)
            listaEjemplares.add(generateISBN());
        Biblioteca.listaLibros.add(this);
    }

//    public boolean prestamo(String titulo){
//        if(ejemplaresDisponibles > 0 && listaEjemplares.getTitulo(titulo)){
//            ejemplaresDisponibles--;
//            return true;
//        }
//
//        return false;
//    }



    public String generateISBN(){
        String numISBN = "";
        for(int i = 0 ; i < 13 ; i++){
            numISBN += String.valueOf((int) (Math.random()*(9+1)));
        }

        return numISBN;
    }

//    public void actualizarEjemplares(int cantidad){
//        listaLibro.ge
//    }

    public String getTitulo() {
        return titulo;
    }


    public String getListaEjemplares(){
        return titulo + "{\n\t" + listaEjemplares + "}";
    }

    @Override
    public String toString() {
        return "\tLibro{\n" +
                "\t\tTítulo: " + titulo + "\n" +
                "\t\tAutor: " + autor + "\n" +
                "\t\tEditorial: " + super.getEditorial() + "\n" +
                "\t\tPáginas: " + super.getPaginas() + "\n" +
                "\t\tColor: " + super.getColor() + "\n" +
                "\t\tEjemplares disponibles: " + ejemplaresDisponibles + "\n\t}\n";
    }
}
