package model;

import java.text.SimpleDateFormat;

public class ListaEjemplaresSocio {

    private int size;
    private Node head;
    private Node tail;

    public ListaEjemplaresSocio() {
    }

    public int getSize() {
        return size;
    }

    public void add(Ejemplar ejemplar){
        Node node = new Node(ejemplar);

        if(head==null) {
            head = node;
            tail = node;
        }
        else{
            tail.setNext(node);
            tail = node;
        }

        size++;
    }

    public Ejemplar get(int index){
        Node aux = head;

        if(index>=size || index < 0)
            return null;
        else {
            while(index > 0){
                aux = aux.getNext();
                index--;
            }
        }

        return aux.getInfo();
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String output = "Historial de Préstamos{\n\t\t" +
                "Total de préstamos: " + size + "\n\n";
        Node aux = head;
        int i = 0;

        while(aux!=null){
            output += "\t\t[Libro: '" + aux.getInfo().getTitulo() + "']\n" +
                    "\t\t" + aux.getInfo() + "]\n" +
                    "\t\t[Fecha de préstamo: " + formatter.format(aux.getInfo().getListaPrestamos().get(aux.getInfo().getListaPrestamos().getSize()-1).getPrestado()) + "]\n" +
                    "\t\t[Fecha de devolución: ";
            if(aux.getInfo().getListaPrestamos().get(aux.getInfo().getListaPrestamos().getSize()-1).getDevuelto()==null)
                output += "No devuelto]\n\n";
            else
                output += formatter.format(aux.getInfo().getListaPrestamos().get(aux.getInfo().getListaPrestamos().getSize()-1).getDevuelto()) + "]\n\n";
            aux = aux.getNext();
            i++;
        }

        return output + "\t}\n";
    }

    class Node{

        private Ejemplar info;
        private Node next;

        public Node (Ejemplar info){
            this.info = info;
            next = null;
        }

        public Ejemplar getInfo() {
            return info;
        }

        public void setInfo(Ejemplar info) {
            this.info = info;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return info.toString();
        }
    }

}
