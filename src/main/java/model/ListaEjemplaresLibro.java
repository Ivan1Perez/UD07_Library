package model;

public class ListaEjemplaresLibro {

    private int size;
    private Node head;
    private Node tail;

    public ListaEjemplaresLibro() {

    }

    public int getSize() {
        return size;
    }

    public void add(Ejemplar info){
        Node node = new Node(info);

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
        Node aux = head;
        boolean estaDisponible = false;

        if(head==null)
            return estaDisponible;
        else{
            while(aux!=null && !estaDisponible){
                if(aux.getInfo().isDisponible() && prestamo.getSocio().getNumPrestamos() < 3){
                    aux.getInfo().setDisponible(false);
                    aux.getInfo().addPrestamo(prestamo);
                    prestamo.getSocio().addEjemplar(aux.getInfo());
                    estaDisponible = true;
                }
                aux = aux.getNext();
            }
        }

        return estaDisponible;
    }

    public ListaPrestamos getListaPrestamos(int index){
        Node aux = head;

        if(index>=size || index < 0)
            return null;
        else{
            while(index > 0) {
                aux = aux.getNext();
                index--;
            }
        }

        return aux.getInfo().getListaPrestamos();
    }

    public Ejemplar get(int index){
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
    public String toString() {
        String output = "Listado de Ejemplares{\n\t\t" +
                "Total de ejemplares: " + size + "\n";
        Node aux = head;

        while(aux!=null){
            if(aux.getInfo().isDisponible())
                output += "\t\t" + aux.getInfo() + "  |  Disponile]\n";
            else
                output += "\t\t" + aux.getInfo() + "  |  Prestado]\n";
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
