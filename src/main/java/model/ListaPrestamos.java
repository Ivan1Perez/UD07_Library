package model;

public class ListaPrestamos {

    private int size;
    private Node head;



    class Node{

        private Libro infoLibro;
        private Socio infoSocio;
        private Node next;

        public Node(Libro infoLibro, Socio infoSocio){
            this.infoLibro = infoLibro;
            this.infoSocio = infoSocio;
            this.next = null;
        }

    }

}
