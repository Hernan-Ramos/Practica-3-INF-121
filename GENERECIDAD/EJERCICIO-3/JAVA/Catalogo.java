import java.sql.Array;
import java.util.ArrayList;
public class Catalogo <H>{
    private ArrayList<H> catalogo;

    public Catalogo(){
        this.catalogo = new ArrayList<>();
    }

    public void Agregar( H objeto ){
        this.catalogo.add(objeto);

    }
    public void Buscar(H encontrar){
        for (int i = 0; i < this.catalogo.size();i++){
            if(this.catalogo.get(i).equals(encontrar)){
                System.out.println("Öbjeto encontrado: " + this.catalogo.get(i));
                return;

            }
        }System.out.println("Objeto no encontrado");
    }


}

