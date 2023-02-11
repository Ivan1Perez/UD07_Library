package model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Prestamo<T> {

    private Date prestado;
    private Date devuelto;
    private T tipo;

    public Prestamo(T tipo) {
        this.tipo = tipo;
        this.prestado = new Date();
        this.devuelto = null;
    }

    public T getTipo() {
        return tipo;
    }

    public void setTipo(T tipo) {
        this.tipo = tipo;
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
        String output = "";

        if (tipo instanceof Ejemplar) {
            output = "\t\t[Título: " + ((Ejemplar) tipo).getTitulo() + "]\n" +
                        tipo;
        } else if (tipo instanceof Socio) {
            output = tipo.toString();
        }
        if (devuelto == null) {
            return output + "\n" +
                    "\t\t[Fecha de préstamo: " + formatter.format(prestado) + "]\n" +
                    "\t\t[Por devolver]\n";
        } else {
            return output + "\n" +
                    "\t\t[Fecha de préstamo: " + formatter.format(prestado) + "]\n" +
                    "\t\t[Fecha de devolución: " + formatter.format(devuelto) + "]\n";
        }
    }
}
