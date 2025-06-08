//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AppCaja {
    public static void main(String[] args) {

        Caja<String> c1 = new Caja<>();
        Caja<Integer> c2 = new Caja<>();

        c1.guardar("Hola");
        c1.guardar("Mundo");

        c2.guardar(2);
        c2.guardar(100);

        c1.obtener();
        c2.obtener();
    }
}