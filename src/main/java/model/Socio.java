package model;

public class Socio{

    private String nombre;
    private String DNI;
    private ListaSE<Ejemplar> listaEjemplares;
    private int numPrestamos;

    public Socio(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        listaEjemplares = new ListaSE<>();
    }

    public void addEjemplar(Ejemplar ejemplar){
        listaEjemplares.add(ejemplar);
    }

    public void addNumPrestamos(){
        numPrestamos++;
    }

    public void removeNumPrestamo(){
        numPrestamos--;
    }

    public int getNumPrestamos() {
        return numPrestamos;
    }

//    public String printListaEjemplares(){
//        int i  = 0;
//        String output = this + "{\n" + "\tTotal: " + listaEjemplares.getSize() + "\n";
//
//        while(i < listaEjemplares.getSize()){
//            output += "\t" + listaEjemplares.get(i).toStringSocio() + "\n";
//            i++;
//        }
//
//        return output + "}";
//    }

    public ListaSE<Ejemplar> getListaEjemplares() {
        return listaEjemplares;
    }

    @Override
    public String toString() {
        return "\t\t[Nombre: " + nombre + "   |   DNI: " + DNI + "   |   Libros por devolver: " + numPrestamos + "]";
    }

    public String toStringPrestamos() {
        return "\t[Nombre: " + nombre + "   |   DNI: " + DNI + "]";
    }

}
