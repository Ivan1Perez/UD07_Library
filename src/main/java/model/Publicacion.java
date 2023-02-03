package model;

public abstract class Publicacion {

    private String editorial;
    private int paginas;
    private Color color;

    public Publicacion(String editorial, int paginas, Color color) {
        this.editorial = editorial;
        this.paginas = paginas;
        this.color = color;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getPaginas() {
        return paginas;
    }

    public Color getColor() {
        return color;
    }

//    public String getTitulo(){
//        return ge
//    }



//    @Override
//    public String toString() {
//        return "Tipo de publicación: ";
//    }
}
