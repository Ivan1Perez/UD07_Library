package model;

public class ListaLibro {

    private int size;

    private Node head;

    public ListaLibro() {

    }

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

    public boolean getTitulo(String titulo){
        Node aux = head;
        boolean encontrado = false;

        if(size==0)
            return encontrado;
        else
            while(aux!=null && !encontrado){
                if(!aux.getInfo().getTitulo().equalsIgnoreCase(titulo))
                    aux = aux.getNext();
                else{
                    encontrado = true;
                }
            }

        return encontrado;
    }

//    public boolean setEjemplares(int cantidad){
//        boolean actualizado = false;
//
//        if(size==0)
//            return actualizado;
//        else
//            while(aux!=null)
//
//        return actualizado;
//    }

    @Override
    public String toString() {
        String output = "Listado de Libros{\n\t" +
                "Total de libros: " + size + "\n";
        Node aux = head;

                while(aux!=null){
                    output += aux.getInfo().toString();
                    aux = aux.getNext();
                }

            return output + "}\n";
    }

    class Node{

        private Libro info;
        private Node next;

        public Node(Libro info){
            this.info = info;
            this.next = null;
        }

        public Libro getInfo() {
            return info;
        }

        public void setInfo(Libro info) {
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
