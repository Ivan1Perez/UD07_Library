package model;

public abstract class Publicacion<T> {

    private String editorial;
    private int paginas;
    private Color color;
    private boolean alta;

    public Publicacion(String editorial, int paginas, Color color) {
        this.editorial = editorial;
        this.paginas = paginas;
        this.color = color;
        alta = true;
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

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

}
