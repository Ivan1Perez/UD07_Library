package model.menu;

public class Opciones {

    public Opciones(){
    }

    public String[] opcionesIniciales(){
        return new String[]{
                ("[1] Buscar un libro. Pulse '1'."),
                ("[2] Obtener un libro. Pulse '2'."),
                ("[3] Devolver un libro. Pulse '3'."),
                ("[4] Ver más opciones. Pulse '4'."),
                ("[5] Salir. Pulse '5'.")
        };
    }

    public String[] masOpciones() {
        return new String[]{
                ("[1] Ver listado de libros. Pulse '1'."),
                ("[2] Ver listado de Revistas. Pulse '2'."),
                ("[3] Ver listado de Periódicos. Pulse '3'."),
                ("[4] Ver listado de socios. Pulse '4'."),
                ("[5] Buscar un libro. Pulse '5'."),
                ("[6] Obtener un libro. Pulse '6'."),
                ("[7] Devolver un libro. Pulse '7'."),
                ("[8] Ver todas las opciones. Pulse '8'."),
                ("[9] Salir. Pulse '9'.")
        };
    }

//    @Override
//    public String toString() {
//        return "¿Qué desea hacer en la biblioteca?\n" +
//                "\t" + opcion1 + "\n" +
//                "\t" + opcion2 + "\n" +
//                "\t" + opcion3 + "\n" +
//                "\t" + opcion4 + "\n";
//    }
}


