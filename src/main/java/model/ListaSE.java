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
                if(((Ejemplar)aux.getInfo()).isDisponible() && prestamo.getSocio().getNumPrestamos() < 3){
                    ((Ejemplar)aux.getInfo()).setDisponible(false);
                    ((Ejemplar)aux.getInfo()).addPrestamo(prestamo);
                    prestamo.getSocio().addEjemplar((Ejemplar) aux.getInfo());
                    estaDisponible = true;
                }
                aux = aux.getNext();
            }
        }

        return estaDisponible;
    }

    public ListaSE<Prestamo> getListaPrestamos(int index){
        Node<T> aux = head;

        if(index>=size || index < 0)
            return null;
        else{
            while(index > 0) {
                aux = aux.getNext();
                index--;
            }
        }

        return ((Ejemplar)aux.getInfo()).getListaPrestamos();
    }

    public Ejemplar getEjemplar(int index){
        Node<T> aux = head;

        if(index>=size || index < 0)
            return null;
        else {
            while(index > 0){
                aux = aux.getNext();
                index--;
            }
        }

        return (Ejemplar) aux.getInfo();
    }

    public Prestamo getPrestamo(int index){
        Node<T> aux = head;

        if(index>=size || index < 0)
            return null;
        else {
            while(index > 0){
                aux = aux.getNext();
                index--;
            }
        }

        return (Prestamo) aux.getInfo();
    }

    @Override
    public String toString() {
        Node<T> aux = head;
        String tipoPublicacion = "publicaciones";
        String output1, output2 = "";

        if(aux!=null) {
            if (aux.getInfo() instanceof Libro)
                tipoPublicacion = "libros";
            else if (aux.getInfo() instanceof Revista)
                tipoPublicacion = "revistas";
            else if(aux.getInfo() instanceof Ejemplar){
                tipoPublicacion = "ejemplares";
                while(aux!=null){
                    if(((Ejemplar) aux.getInfo()).isDisponible())
                        output2 += "\t\t" + aux.getInfo() + "  |  Disponile]\n";
                    else
                        output2 += "\t\t" + aux.getInfo() + "  |  Prestado]\n";
                    aux = aux.getNext();
                }
            }
            else if(aux.getInfo() instanceof Prestamo)
                tipoPublicacion = "préstamos";
            else if(aux.getInfo() instanceof Socio)
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

    public static class Node<T> {

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
