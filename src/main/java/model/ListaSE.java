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

    public T get(int index){
        Node<T> aux = head;

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

    public T containsElement(T info){
        Node<T> aux = head;

        while (aux != null) {
            if (aux.info.equals(info)) {
                return aux.info;
            }
            aux = aux.getNext();
        }
        return null;
    }

    public boolean contains(T info){

        boolean encontrado = false;

        Node<T> aux = head;

        while(aux!=null && !encontrado){
            if(aux.getInfo().equals(info))
                encontrado = true;

            aux = aux.getNext();
        }

        return encontrado;
    }

    public boolean addAll(ListaSE<T> l){

        boolean modificado = false;
        Node<T> aux = l.head;
        int originalSize = l.size;

        for(int i=0;i<originalSize;i++) {
            add(aux.getInfo());
            aux = aux.getNext();
            modificado = true;
        }

        return modificado;
    }

    public Integer remove(int index){
        if(index>=size||index<0){
            return null;
        }

        Integer value = null;

        if(index==0){
            head = head.getNext();
        }else{
            Node<T> aux = head;
            Node<T> aux2 = head.getNext();

            while(index>1){
                aux=aux2;
                aux2=aux2.getNext();
                index--;
            }
            value = (Integer) aux2.getInfo();
            aux.setNext(aux2.getNext());
        }

        size--;
        return value;
    }

    @Override
    public String toString() {
        return "Total: " + size + "\n\tValues: \n" + ((head == null) ? "\n}" : head.toString());
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
            return "" + info + ((next != null) ? "\n" + next : "\n");
        }
    }

}
