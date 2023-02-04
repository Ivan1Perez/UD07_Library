package model;

import java.util.Date;

public class Prestamo {

    private Date prestado;
    private Date devuelto;
    private Socio socio;
    private ListaPrestamos listaPrestamos = new ListaPrestamos();

    public Prestamo(Socio socio, Date prestado, Date devuelto) {
        this.socio = socio;
        this.prestado = prestado;
        this.devuelto = devuelto;
        listaPrestamos.add(this);
    }

    public ListaPrestamos getListaPrestamos() {
        return listaPrestamos;
    }

    @Override
    public String toString() {
        return "[Socio: " + socio + "\n Fecha de prestación: " + prestado + "]";
    }
}
