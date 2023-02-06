package model;

public class ListaPrestamos {

    private int size;
    private Node head;
    private Node tail;

    public ListaPrestamos() {
    }

    public int getSize() {
        return size;
    }

    public void add(Prestamo info){
        Node node = new Node(info);

        if(head==null){
            head = node;
            tail = node;
        }
        else{
            tail.setNext(node);
            tail = node;
        }

        size++;
    }

    public Prestamo get(int index){
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
    public String toString(){
        String output = "Listado de préstamos{\n\t\t" +
                "Total de préstamos: " + size + "\n\n";

        Node aux = head;

        while(aux!=null){
            output += aux.getInfo() + "\n";
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
