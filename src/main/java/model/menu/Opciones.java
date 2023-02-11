package model.menu;

public class Opciones {

    public Opciones(){
    }

    public static String[] opcionesIniciales(){
        return new String[]{
                ("Nota: Si no sabe que libro buscar vaya a 'Ver más opciones' y pulse 'Ver listado de libros'."),
                ("[1] Buscar un libro. Pulse '1'."),
                ("[2] Obtener un libro. Pulse '2'."),
                ("[3] Devolver un libro. Pulse '3'."),
                ("[4] Ver más opciones. Pulse '4'."),
                ("[5] Salir. Pulse '5'.")
        };
    }

    public static String[] masOpciones() {
        return new String[]{
                ("[1] Ver listado de libros. Pulse '1'."),
                ("[2] Ver listado de Revistas. Pulse '2'."),
                ("[3] Ver listado de Periódicos. Pulse '3'."),
                ("[4] Ver listado de socios. Pulse '4'."),
                ("[5] Comprobar los préstamos de un ejemplar. Pulse '5'."),
                ("[6] Comprobar los préstamos de un socio. Pulse '6'."),
                ("[7] Dar de alta/baja una publicación. Pulse '7'."),
                ("[8] Dar de alta/baja/modificar un socio. Pulse '8'."),
                ("[9] Volver. Pulse '9'.")
        };
    }

    public static String[] opcionesRegreso() {
        return new String[]{
                ("[1] Volver al menú principal → Pulse '1'"),
                ("[2] Salir → Pulse '2'")
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


