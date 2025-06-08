public class AppCatalogo {
    public static void main(String[] args) {
        Producto p1 = new Producto("Perfume");
        Producto p2 = new Producto("Carrito");

        Libros l1 = new Libros("Cien años de soledad");
        Libros l2 = new Libros("Eragon");
        Libros l3 = new Libros("Sherlock Holmes");
        Libros l4 = new Libros("Maze Runner");

        Catalogo<Producto> c1 = new Catalogo<>();
        Catalogo<Libros> c2 = new Catalogo<>();
        c1.Agregar(p1);
        c1.Agregar(p2);
        c2.Agregar(l1);
        c2.Agregar(l2);
        c2.Agregar(l4);

        c1.Buscar(p1);
        c2.Buscar(l3);
        c2.Buscar(l4);


    }
}
