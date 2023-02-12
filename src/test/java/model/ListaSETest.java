package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ListaSETest<T> {

    private static Biblioteca b1;
    private static Libro l1;

    @BeforeAll
    public static void init(){
        b1 = new Biblioteca<>();
        l1 = new Libro("El Papel", 348, Color.BLANCOYNEGRO,
                "Antonio Cabanas", "El camino de los dioses", "1122443399441"
                , 5);
        b1.addLibro(l1);
        b1.addLibro(l1);
        b1.addLibro(l1);
        b1.addLibro(l1);
        b1.addLibro(l1);

    }

    @Test
    void add(){
        ListaSE<Libro> lista = new ListaSE<>();
        lista.add(l1);
        lista.add(l1);
        lista.add(l1);
        lista.add(l1);
        lista.add(l1);


        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                System.out.println(lista);
            }
        });
    }


}