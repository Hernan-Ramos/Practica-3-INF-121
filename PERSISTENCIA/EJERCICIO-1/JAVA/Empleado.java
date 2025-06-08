public class Empleado {
    private String nombre;
    private int edad;
    private float salario;
    public Empleado(String nombre, int edad, float salario){
        this.nombre= nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public float getSalario() {
        return salario;
    }
}
