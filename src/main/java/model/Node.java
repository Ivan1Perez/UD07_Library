package model;

public class Node {

    private Publicacion info;
    private Node next;

    public Node(Publicacion info) {
        this.info = info;
        this.next = null;
    }

    public Publicacion getInfo() {
        return info;
    }

    public void setInfo(Publicacion info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString(){

        return info.toString();

    }
}
