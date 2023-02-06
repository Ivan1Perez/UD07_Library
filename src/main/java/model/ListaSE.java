package model;

public class ListaSE<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public ListaSE() {
    }

    public int getSize() {
        return size;
    }

    public void add(T info){
        Node<T> node = new Node<>(info);

        if(head==null) {
            head = node;
            tail = node;
        }
        else{
            tail.setNext(node);
            tail = node;
        }

        size++;
    }

    public boolean disponible(Prestamo prestamo){
        Node<T> aux = head;
        boolean estaDisponible = false;

        if(head==null)
            return estaDisponible;
        else{
            while(aux!=null && !estaDisponible){
                if(aux.getInfo().isDisponible() && prestamo.getSocio().getNumPrestamos() < 3){
                    aux.getInfo().setDisponible(false);
                    aux.getInfo().addPrestamo(prestamo);
                    prestamo.getSocio().addEjemplar((Ejemplar) aux.getInfo());
                    estaDisponible = true;
                }
                aux = aux.getNext();
            }
        }

        return estaDisponible;
    }

    @Override
    public String toString() {
        Node<T> aux = head;
        String tipoPublicacion = "publicaciones";
        String output1, output2 = "";

        if(head!=null) {
            if (head.getInfo() instanceof Libro)
                tipoPublicacion = "libros";
            else if (head.getInfo() instanceof Revista)
                tipoPublicacion = "revistas";
            else if(head.getInfo() instanceof Ejemplar){
                tipoPublicacion = "ejemplares";
                while(aux!=null){
                    if(aux.getInfo().isDisponible())
                        output2 += "\t\t" + aux.getInfo() + "  |  Disponile]\n";
                    else
                        output2 += "\t\t" + aux.getInfo() + "  |  Prestado]\n";
                    aux = aux.getNext();
                }
            }
            else if(head.getInfo() instanceof Prestamo)
                tipoPublicacion = "préstamos";
            else if(head.getInfo() instanceof Socio)
                tipoPublicacion = "socios";
            else
                tipoPublicacion = "periódicos";
        }

        output1 = "Listado de " + tipoPublicacion + "{\n" +
                "\tTotal de " + tipoPublicacion + ": " + size + "\n\n";

        while(aux!=null){
            output1 += aux.getInfo() + "\n";
            aux = aux.getNext();
        }

        return output1 + output2 + "\t}\n";
    }

    class Node<T> {

        private T info;
        private Node<T> next;

        public Node(T info){
            this.info = info;
            next = null;
        }

        public T getInfo() {
            return info;
        }

        public void setInfo(T info) {
            this.info = info;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return info.toString();
        }
    }

}
