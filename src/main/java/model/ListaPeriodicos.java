package model;

public class ListaPeriodicos {

    private int size;
    private Node head;

    public ListaPeriodicos(){

    }

    public void add(Periodico periodico){
        Node node = new Node(periodico);

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
        ListaPeriodicos.Node aux = head;
        String output = "Listado de periódicos{\n" +
                "\tTotal de periódicos: " + size + "\n\n";

        while(aux!=null){
            output += aux.getInfo() + "\n";
            aux = aux.getNext();
        }

        return output + "}";
    }

    class Node{

        private Periodico info;
        private Node next;

        public Node(Periodico info) {
            this.info = info;
            next = null;
        }

        public Periodico getInfo() {
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
