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
                if(opcion > 0 && opcion < 11)
                    correcto = true;
                else {
                    System.out.println("Error. Has de introducir un número mayor que 0 y menor que 11");
                    sc.nextLine();
                }
            }else {
                System.out.println("Error. Has de introducir un número mayor que 0 y menor que 11");
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
        System.out.println("Vuelva a introducir su DNI para realizar el préstamo/devolución.");

        return new Socio(nombre, DNI);
    }

    public boolean libroBuscado(Libro libro){
        Scanner sc = new Scanner(System.in);
        String respuesta;
        boolean respCorrecta = false;

        System.out.println("¿Es este el libro que buscabas?\n" +
                libro);
        System.out.println("Sí → Pulsa [S]");
        System.out.println("No → Pulsa [N]");

        do{
            respuesta = sc.next();
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
        Scanner sc = new Scanner(System.in);
        int respuesta;
        boolean correcto = false;

        System.out.println(Confirmacion.TITLE_NOTFOUND.getRespuesta());

        while(!correcto){
            if(sc.hasNextInt()) {
                respuesta = sc.nextInt();
                if(respuesta > 0 && respuesta < 3) {
                    correcto = true;
                }
                else {
                    System.out.println("Error. Has de introducir un '1' o un '2'");
                    sc.nextLine();
                }
            }else {
                System.out.println("Error. Has de introducir un '1' o un '2'");
                sc.nextLine();
            }
        }
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

    public int checkCodEjemplar(){
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean correcto = false;

        do {
            System.out.println("Introduzca el código del ejemplar:");
            if(!sc.hasNextInt())
                System.out.println("Error. Has de introducir un número.");
            else{
                num = sc.nextInt();
                correcto = true;
            }
        }while(!correcto);


        return num;
    }
}
