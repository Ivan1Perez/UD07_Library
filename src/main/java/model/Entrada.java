package model;

import java.util.Scanner;

public class Entrada {

    public Entrada() {
    }

    public int checkOpcionesPrincipales(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean correcto = false;

        while (!correcto) {
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion > 0 && opcion < 6) {
                    correcto = true;
                } else {
                    System.out.println("Error. Por favor introduce uno de los siguientes números: [1, 2, 3, 4 o 5]");
                    sc.nextLine();
                }
            } else {
                System.out.println("Error. Por favor introduce uno de los siguientes números: [1, 2, 3, 4 o 5]");
                sc.nextLine();
            }
        }

        return opcion;
    }

    public int checkMasOpciones(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean correcto = false;

        while(!correcto){
            if(sc.hasNextInt()) {
                opcion = sc.nextInt();
                if(opcion > 0 && opcion < 10)
                    correcto = true;
                else {
                    System.out.println("Error. Has de introducir un número mayor que 0 y menor que 10");
                    sc.nextLine();
                }
            }else {
                System.out.println("Error. Has de introducir un número mayor que 0 y menor que 10");
                sc.nextLine();
            }
        }


        return opcion;
    }

    public String titulo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza el título del libro:");

        return sc.nextLine();
    }

    public String DNI(){
        Scanner sc = new Scanner(System.in);
        String DNI;
        boolean correcto = false;

        do{
            System.out.println("Introduzca el DNI:");
            DNI = sc.nextLine();

            if(DNI.length() != 9){
                System.out.println("Error. El DNI tiene que tener 8 dígitos y una letra.");
            }
            else
                correcto = true;
        }while(!correcto);

        return DNI;
    }

    public int opciones1_2(){
        Scanner sc = new Scanner(System.in);
        int respuesta = 0;
        boolean correcto = false;

        while(!correcto){
            if(sc.hasNextInt()) {
                respuesta = sc.nextInt();
                if(respuesta > 0 && respuesta < 3)
                    correcto = true;
                else {
                    System.out.println("Error. Has de introducir un '1' o un '2'");
                    sc.nextLine();
                }
            }else {
                System.out.println("Error. Has de introducir un '1' o un '2'");
                sc.nextLine();
            }
        }


        return respuesta;
    }

    public int opciones1_2_3(){
        Scanner sc = new Scanner(System.in);
        int respuesta = 0;
        boolean correcto = false;

        while(!correcto){
            if(sc.hasNextInt()) {
                respuesta = sc.nextInt();
                if(respuesta > 0 && respuesta < 4)
                    correcto = true;
                else {
                    System.out.println("Error. Has de introducir un '1',un '2' o un '3'.");
                    sc.nextLine();
                }
            }else {
                System.out.println("Error. Has de introducir un '1', un '2' o un '3'.");
                sc.nextLine();
            }
        }


        return respuesta;
    }

    public Socio crearSocio(ListaSE<Socio> listaSocios){
        String nombre = nombre(), DNI;
        int i = 0;

        DNI = DNI();

        do{
            if (DNI.equalsIgnoreCase(listaSocios.get(i).getDNI())) {
                System.out.println("Error, ya existe un socio con este DNI. Prueba de nuevo");
                DNI = DNI();
                i = -1;
            }
            i++;
        }while(i < listaSocios.getSize());

        System.out.println("Socio creado!");
        System.out.println("Vuelva a introducir su DNI para completar el trámite.");

        return new Socio(nombre, DNI);
    }

    public <T> boolean busquedaPublicacion(T publicacion){
        Scanner sc = new Scanner(System.in);
        String respuesta, tipo;
        boolean respCorrecta = false;

        if(publicacion instanceof Libro)
            tipo = "e el libro";
        else
            tipo = "a la publicación";

        System.out.println("¿Es est" + tipo + "que buscabas?\n" +
                publicacion);
        System.out.println("Sí → Pulsa [S]");
        System.out.println("No → Pulsa [N]");

        do{
            respuesta = sc.nextLine();
            if(respuesta.equalsIgnoreCase("N") || respuesta.equalsIgnoreCase("S")){
                respCorrecta = true;
            }
            else
                System.out.println("Error. Debes introducir [S] o [N]");
        }while(!respCorrecta);

        if(respuesta.equalsIgnoreCase("S"))
            return true;

        return false;
    }

    public String nombre(){
        Scanner sc = new Scanner(System.in);
        String nombre;
        boolean nomCorrecto = false;

        do{
            System.out.println("Introduce nombre y apellidos");
            nombre = sc.nextLine();
            if(nombre.length() > 1)
                nomCorrecto = true;
            else
                System.out.println("Error. El nombre ha de tener al menos dos caracteres.");
        }while(!nomCorrecto);

        return nombre;
    }

    public void tituloNoCoincide(){
        System.out.println(Confirmacion.TITLE_NOTFOUND.getRespuesta());
    }

    public int DNI_NoEncontrado() {
        Scanner sc = new Scanner(System.in);
        int respuesta = 0;
        boolean correcto = false;

        System.out.println(Confirmacion.DNI_NOTFOUND.getRespuesta());

        while (!correcto) {
            if (sc.hasNextInt()) {
                respuesta = sc.nextInt();
                if (respuesta > 0 && respuesta < 3)
                    correcto = true;
                else {
                    System.out.println("Error. Has de introducir un '1' o un '2'");
                    sc.nextLine();
                }
            } else {
                System.out.println("Error. Has de introducir un '1' o un '2'");
                sc.nextLine();
            }
        }
        return respuesta;
    }

    public int checkCodEjemplar() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean correcto = false;

        while (!correcto) {
            System.out.println("Introduzca el código del ejemplar:\n" +
                    "Nota: los códigos van desde el 1 al número total de ejemplares");
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                correcto = true;
            } else {
                System.out.println("Error. Has de introducir un número.");
                sc.nextLine();
            }
        }

        return num;
    }

    public String tituloPublicacion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre o título de la publicación:");

        return sc.nextLine();
    }

    public boolean opcionSi_No(){
        Scanner sc = new Scanner(System.in);
        String respuesta;
        boolean respCorrecta = false;

        System.out.println("Sí → Pulsa [S]");
        System.out.println("No → Pulsa [N]");

        do{
            respuesta = sc.nextLine();
            if(respuesta.equalsIgnoreCase("N") || respuesta.equalsIgnoreCase("S")){
                respCorrecta = true;
            }
            else
                System.out.println("Error. Debes introducir [S] o [N]");
        }while(!respCorrecta);

        if(respuesta.equalsIgnoreCase("S"))
            return true;

        return false;
    }

    public String checkNewDNI(ListaSE<Socio> listaSocios){
        String DNI;
        int i = 0;

        System.out.println("A continuación ingrese el nuevo DNI.");
        DNI = DNI();

        do{
            if (DNI.equalsIgnoreCase(listaSocios.get(i).getDNI())) {
                System.out.println("Error, ya existe un socio con este DNI. Prueba de nuevo");
                DNI = DNI();
                i = -1;
            }
            i++;
        }while(i < listaSocios.getSize());

        System.out.println("DNI actualizado.");

        return DNI;
    }

}
