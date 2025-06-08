public class Libros {
    private String libro;
    public Libros(String nombrelibro){
        this.libro  = nombrelibro;
    }
    public String toString(){
        return " " + this.libro + " ";
    }
    public String getNombre(){
        return this.libro;
    }
}
