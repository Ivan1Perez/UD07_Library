package model;

public class ListaEjemplares {

    private int size;

    private Node head;

    public ListaEjemplares() {

    }

    public void add(Ejemplar info){
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
    public String toString() {
        String output = "Listado de Ejemplares{\n\t\t" +
                "Total de ejemplares: " + size + "\n";
        Node aux = head;

                while(aux!=null){
                    output += "\t\t" + aux.getInfo() + "\n";
                    aux = aux.getNext();
                }

            return output + "\t}\n";
    }

    class Node{

        private Ejemplar info;
        private Node next;

        public Node(Ejemplar info){
            this.info = info;
            this.next = null;
        }

        public Ejemplar getInfo(){
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
