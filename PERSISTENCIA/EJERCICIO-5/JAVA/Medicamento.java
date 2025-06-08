public class Medicamento {
    private String nombre;
    private int codMedicamento;
    private String tipo;
    private double precio;

    public Medicamento() {}

    public Medicamento(String nombre, int codMedicamento, String tipo, double precio) {
        this.nombre = nombre;
        this.codMedicamento = codMedicamento;
        this.tipo = tipo;
        this.precio = precio;
    }

    public void leer(String nombre, int cod, String tipo, double precio) {
        this.nombre = nombre;
        this.codMedicamento = cod;
        this.tipo = tipo;
        this.precio = precio;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codMedicamento);
        System.out.println("Tipo: " + tipo);
        System.out.println("Precio: " + precio);
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String toFileString() {
        return nombre + "\n" + codMedicamento + "\n" + tipo + "\n" + precio;
    }
}
