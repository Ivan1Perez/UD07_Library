package model;

public enum Confirmacion {

    DNI_NOTFOUND("El DNI introducido no coincide con nínguno de esta biblioteca.\n" +
            "[1] Introducir DNI de nuevo → Pulse '1'\n" +
            "[2] Nuevo socio → Pulse '2'\n"),
    TITLE_NOTFOUND("El título introducido no coincide con ninguno de esta biblioteca.\n" +
            "[1] Introducir título de nuevo → Pulse '1'\n" +
            "[2] Salir → Pulse '2'"),
    LOAN_DONE("Préstamo realizado con éxito."),
    LOAN_NOTDONE("No se ha podido realizar el préstamo"),
    RETURN_DONE("Devolución realizada con éxito."),
    RETURN_NOTDONE("No se pudo realizar la devolución");

    private String respuesta;

    Confirmacion(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }
}
