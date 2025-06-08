import java.util.ArrayList;
public class Caja <T> {
    private ArrayList<T> caja;
    public Caja(){
        this.caja = new ArrayList<>();
    }
    public void guardar( T objeto){
        this.caja.add(objeto);
    }
    public void obtener(){
        for(int i = 0; i < this.caja.size(); i++ ){
            System.out.println(this.caja.get(i));
            }
    }
}
