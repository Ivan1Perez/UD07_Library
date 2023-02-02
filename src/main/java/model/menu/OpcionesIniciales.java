package model.menu;

public class OpcionesIniciales {

    private final String opcion1 = "[1] Ver listado de libros. Pulse '1'.";
    private final String opcion2 = "[2] Ver listado de Revistas. Pulse '2'.";
    private final String opcion3 = "[3] Ver listado de Periódicos. Pulse '3'.";
    private final String opcion4 = "[4] Ver todas las publicaciones. Pulse '4'.";

    public OpcionesIniciales(){
    }

    @Override
    public String toString() {
        return "¿Qué desea hacer en la biblioteca?\n" +
                "\t" + opcion1 + "\n" +
                "\t" + opcion2 + "\n" +
                "\t" + opcion3 + "\n" +
                "\t" + opcion4 + "\n";
    }
}


