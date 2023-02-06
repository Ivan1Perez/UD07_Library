package model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Prestamo {

    private Date prestado;
    private Date devuelto;
    private Socio socio;

    public Prestamo(Socio socio, Date prestado, Date devuelto) {
        this.socio = socio;
        this.prestado = prestado;
        this.devuelto = devuelto;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setDevuelto(Date devuelto) {
        this.devuelto = devuelto;
    }

    public Date getPrestado() {
        return prestado;
    }

    public Date getDevuelto() {
        return devuelto;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        if(devuelto==null)
            return socio + "\n\t\t[Fecha de préstamo: " + formatter.format(prestado) + "]\n";

        return socio + "\n\t\t[Fecha de préstamo: " + formatter.format(prestado) + "]\n" +
                "\t\t[Fecha de devolución: " + formatter.format(devuelto) + "]\n";
    }
}
