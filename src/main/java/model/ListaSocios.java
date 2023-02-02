package model;

public class ListaSocios {

    private int size;
    private Node head;

    public ListaSocios() {
    }

    public void add(Socio socio){
        Node node = new Node(socio);

        if(head==null)
            head = node;
        else {
            node.setNext(head);
            head = node;
        }
    }

    @Override
    public String toString() {
        ListaSocios.Node aux = head;
        String output = "Listado de socios{\n" +
                "\tTotal de socios: " + size + "\n\n";

        while(aux!=null){
            output += aux.getInfo() + "\n";
            aux = aux.getNext();
        }

        return output + "}";
    }

    class Node{

        private Socio info;
        private Node next;

        public Node(Socio info) {
            this.info = info;
            next = null;
        }

        public Socio getInfo() {
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
            return info.toString();
        }
    }

}
