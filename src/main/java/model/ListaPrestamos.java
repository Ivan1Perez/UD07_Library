package model;

public class ListaPrestamos {

    private int size;
    private Node head;

    public ListaPrestamos() {
    }

    public void add(Prestamo info){
        Node node = new Node(info);

        if(head==null)
            head = node;
        else{
            node.setNext(head);
            head = node;
        }

        size++;
    }

    @Override
    public String toString(){
        String output = "Listado de préstamos{\n\t\t" +
                "Total de préstamos: " + size + "\n";

        Node aux = head;

        while(aux!=null){
            output += aux.getInfo();
            aux = aux.getNext();
        }

        return output;
    }

    class Node{

        private Prestamo info;
        private Node next;

        public Node(Prestamo info) {
            this.info = info;
            this.next = null;
        }

        public Prestamo getInfo() {
            return info;
        }

        public void setInfo(Prestamo info) {
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
