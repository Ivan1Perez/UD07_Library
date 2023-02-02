package model;

import java.util.Scanner;

public class Entrada {

    private int opcionInicial;

    public Entrada() {
        getOpcionInicial();
    }

    public int getOpcionInicial(){
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

        return opcion;
    }
}
