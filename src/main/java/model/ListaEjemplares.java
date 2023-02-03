package model;

public class ListaEjemplares {

    private int size;

    private Node head;

    public ListaEjemplares() {

    }

    public void add(Socio info){
        Node node = new Node(info);

        if(head==null)
            head = node;
        else{
            node.setNext(head);
            head = node;
        }

        size++;
    }

    public boolean estaDisponible(Socio socio){
        boolean disponible = false;

        Node aux = head;

        while(aux!=null && !disponible){
            if(aux.getInfo()==null) {
                aux.setInfo(socio);
                disponible = true;
            }
                aux = aux.getNext();
        }

        return disponible;
    }

    public int getTotalDisponibles(){
        int numDisponibles = 0;

        Node aux = head;

        while(aux!=null){
            if(aux.getInfo()==null)
                numDisponibles++;
            aux = aux.getNext();
        }

        return numDisponibles;
    }

    @Override
    public String toString() {
        String output = "Listado de Ejemplares{\n\t\t" +
                "Total de ejemplares: " + size + "\n";
        Node aux = head;
        int i = 0;

                while(aux!=null){
                    if(aux.getInfo()==null)
                        output += "\t\t[Código " + (++i) + "] | [Disponible]\n";
                    else
                        output += "\t\t[Código " + (++i) + "] | [Prestado a: " + aux.getInfo() + "\t]\n";
                    aux = aux.getNext();
                }

            return output + "\t}\n";
    }

    class Node{

        private Socio info;
        private Node next;

        public Node(Socio info){
            this.info = info;
            this.next = null;
        }

        public Socio getInfo(){
            return info;
        }

        public void setInfo(Socio info) {
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
