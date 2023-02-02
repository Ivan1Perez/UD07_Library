package model;

public class ListaEjemplares {

    private int size;

    private Node head;

    public ListaEjemplares() {

    }

    public void add(String info){
        Node node = new Node(info);

        if(head==null)
            head = node;
        else{
            node.setNext(head);
            head = node;
        }

        size++;
    }

//    public boolean getTitulo(String titulo){
//        Node aux = head;
//        boolean encontrado = false;
//
//        if(size==0)
//            return encontrado;
//        else
//            while(aux!=null && !encontrado){
//                if(!aux.getInfo().contains(titulo))
//                    aux = aux.getNext();
//                else{
//                    encontrado = true;
//                }
//            }
//
//        return encontrado;
//    }

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
        String output = "Listado de Ejemplares{\n\t\t" +
                "Total de ejemplares: " + size + "\n";
        Node aux = head;
        int i = 0;

                while(aux!=null){
                    if(aux.getInfo().equalsIgnoreCase("disponible"))
                        output += "\t\t[Código " + (++i) + "] | [" + aux.getInfo() + "]\n";
                    else
                        output += "\t\t[Código " + (++i) + "] | [Prestado a: " + aux.getInfo() + "]\n";
                    aux = aux.getNext();
                }

            return output + "\t}\n";
    }

    class Node{

        private String ISBN;
        private Node next;

        public Node(String ISBN){
            this.ISBN = ISBN;
            this.next = null;
        }

        public String getInfo(){
            return ISBN;
        }

        public void setInfo(String ISBN) {
            this.ISBN = ISBN;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return ISBN;
        }
    }

}
