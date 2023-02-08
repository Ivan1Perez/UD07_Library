package model;

import java.util.Scanner;

public class Entrada {

    private int opcion;

    public Entrada() {
    }

    public int selecOpcionesIniciales(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean correcto = false;

        while(!correcto){
            if(sc.hasNextInt()) {
                opcion = sc.nextInt();
                if(opcion > 0 && opcion < 6)
                    correcto = true;
                else {
                    System.out.println("Error. Has de introducir uno de estos números → [1,2,3,4 o 5]");
                    sc.next();
                }
            }else {
                System.out.println("Error. Has de introducir uno de estos números → [1,2,3,4 o 5]");
                sc.next();
            }
        }

        this.opcion = opcion;

        return this.opcion;
    }

    public int selecOpcionesTotales(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean correcto = false;

        while(!correcto){
            if(sc.hasNextInt()) {
                opcion = sc.nextInt();
                if(opcion > 0 && opcion < 5)
                    correcto = true;
                else {
                    System.out.println("Error. Has de introducir uno de estos números → [1,2,3 o 4]");
                    sc.next();
                }
            }else {
                System.out.println("Error. Has de introducir uno de estos números → [1,2,3 o 4]");
                sc.next();
            }
        }

        this.opcion = opcion;

        return this.opcion;
    }

    public String texto(){
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }

}
