package model;

public class ListaLibros {

    private int size;
    private Node head;


    public void add(Libro libro){
        Node node = new Node(libro);

        if(head==null)
            head = node;
        else{
            node.setNext(head);
            head = node;
        }

        size++;
    }

    public boolean getLibro(String titulo, Socio socio){
        Node aux = head;
        boolean encotrado = false;
        boolean disponible = false;

        if(head==null)
            return encotrado;
        else{
            while(aux!=null && !encotrado){
                if(aux.getInfo().getTitulo().equalsIgnoreCase(titulo)){
                    encotrado = true;
                    if(aux.getInfo().getListaEjemplares().estaDisponible(socio)){
                        disponible = true;
                    }
                }
                aux = aux.getNext();
            }

        }
        return disponible;
    }

    @Override
    public String toString() {
        Node aux = head;
        String output = "Listado de libros{\n" +
                "\tTotal de libros: " + size + "\n\n";

        while(aux!=null){
            output += aux.getInfo() + "\n";
            aux = aux.getNext();
        }

        return output + "}";
    }

    class Node{

        private Libro info;
        private Node next;

        public Node(Libro info){
            this.info = info;
            next = null;
        }

        public Libro getInfo() {
            return info;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return info + "\n";
        }
    }

}
