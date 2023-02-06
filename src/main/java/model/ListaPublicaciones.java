//package model;
//
//public class ListaPublicaciones {
//
//    private int size;
//    private Node head;
//
//    public ListaPublicaciones() {
//    }
//
//    public void add(Publicacion info){
//        Node node = new Node(info);
//
//        if(head==null)
//            head = node;
//        else{
//            node.setNext(head);
//            head = node;
//        }
//
//        size++;
//    }
//
//
//    @Override
//    public String toString() {
//        Node aux = head;
//        String tipo = "publicaciones";
//
//        if(head!=null) {
//            if (head.getInfo() instanceof Libro)
//                tipo = "libros";
//            else if (head.getInfo() instanceof Revista)
//                tipo = "revistas";
//            else
//                tipo = "periódicos";
//        }
//
//        String output = "Listado de " + tipo + "{\n" +
//                "\tTotal de " + tipo + ": " + size + "\n\n";
//
//        while(aux!=null){
//            output += aux.getInfo() + "\n";
//            aux = aux.getNext();
//        }
//
//        return output + "\t}";
//    }
//
//    class Node{
//
//        private Publicacion info;
//        private ListaEjemplaresLibro listaEjemplares;
//        private Node next;
//
//
//        public Node(Publicacion info) {
//            this.info = info;
//            next = null;
//            if(info instanceof Libro)
//                listaEjemplares = ((Libro) info).getListaEjemplares();
//        }
//
//        public Publicacion getInfo() {
//            return info;
//        }
//
//        public void setInfo(Publicacion info) {
//            this.info = info;
//        }
//
//        public Node getNext() {
//            return next;
//        }
//
//        public void setNext(Node next) {
//            this.next = next;
//        }
//
//        @Override
//        public String toString() {
//            return info.toString();
//        }
//    }
//
//}
