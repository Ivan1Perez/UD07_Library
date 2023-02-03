package model;

public class ListaRevistas {

    private int size;
    private Node head;

    public ListaRevistas(){

    }

    public void add(Revista revista){
        Node node = new Node(revista);

        if(head==null)
            head = node;
        else{
            node.setNext(head);
            head = node;
        }

        size++;
    }

    @Override
    public String toString() {
        ListaRevistas.Node aux = head;
        String output = "Listado de revistas{\n" +
                "\tTotal de revistas: " + size + "\n\n";

        while(aux!=null){
            output += aux.getInfo() + "\n";
            aux = aux.getNext();
        }

        return output + "\t}";
    }

    class Node{

        private Revista info;
        private Node next;

        public Node (Revista info){
            this.info = info;
            next = null;
        }

        public Revista getInfo() {
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
