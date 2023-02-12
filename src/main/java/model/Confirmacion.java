package model;

public enum Confirmacion {

    DNI_NOTFOUND("El DNI introducido no coincide con nínguno de esta biblioteca.\n" +
            "[1] Introducir DNI de nuevo → Pulse '1'\n" +
            "[2] Nuevo socio → Pulse '2'\n"),
    TITLE_NOTFOUND("El título introducido no coincide con ninguno de esta biblioteca"),
    LOAN_DONE("Préstamo realizado con éxito."),
    LOAN_NOTDONE1("No se pudo realizar el préstamo.\n" +
            "Ya ha alcanzado el número máximo de préstamos (3)."),
    LOAN_NOTDONE2("Lo sentimos, este libro no cuenta con ningún ejemplar disponible por el momento."),
    RETURN_DONE("Devolución realizada con éxito."),
    RETURN_NOTDONE1("No es posible realizar una devolución si no se tiene ningún libro que devolver."),
    RETURN_NOTDONE2("El libro no coincide con ninguno de sus préstamos.");


    private String respuesta;

    Confirmacion(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }
}
