import java.io.*;

public class ArchivoEmpleado {
    private String nomA;
    File archivo;

    public ArchivoEmpleado(String n){
        this.nomA = n;
    }

    public void crearArchivo(){
        archivo = new File(this.nomA + ".txt");
        try{
            if(archivo.createNewFile()){
                System.out.println("Archivo creado con exito");
            }else{
                System.out.println("El archivo ya existe");
            }
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
    }

    public void eliminarArchivo(){
        if(archivo.delete()){
            System.out.println("Archivo eliminado con exito");
        }else{
            System.out.println("Error al eliminar el archivo");
        }
    }

    public void guardarEmpleado(Empleado e){
        try{
            // Modo append (agrega al final)
            FileWriter escritura = new FileWriter(archivo, true);
            escritura.write(e.getNombre() + "\n");
            escritura.write(e.getEdad() + "\n");
            escritura.write(e.getSalario() + "\n");
            escritura.close();
        }catch(IOException exception){
            exception.printStackTrace(System.out);
        }
    }

    public void buscarEmpleado(String nombreBuscado){
        try(FileReader instruccion = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(instruccion)) {

            String nombreLinea;
            boolean encontrado = false;

            while ((nombreLinea = lector.readLine()) != null){
                int edad = Integer.parseInt(lector.readLine());
                float salario = Float.parseFloat(lector.readLine());

                if (nombreLinea.equals(nombreBuscado)){
                    System.out.println("Empleado encontrado:");
                    System.out.println("Nombre: " + nombreLinea);
                    System.out.println("Edad: " + edad);
                    System.out.println("Salario: " + salario);
                    encontrado = true;
                    break; // salir después de encontrar
                }
            }

            if (!encontrado) {
                System.out.println("Empleado no encontrado.");
            }

        } catch(IOException ex){
            ex.printStackTrace(System.out);
        }
    }

    public void mayorSalario(float s){
        try(FileReader instruccion = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(instruccion)) {

            String nombreLinea;
            float mayorSalario = -1;
            String empleadoMayorSalario = "";
            boolean encontrado = false;

            while ((nombreLinea = lector.readLine()) != null){
                int edad = Integer.parseInt(lector.readLine());
                float salario = Float.parseFloat(lector.readLine());

                if (salario > s && salario > mayorSalario){
                    mayorSalario = salario;
                    empleadoMayorSalario = "Nombre: " + nombreLinea + "\nEdad: " + edad + "\nSalario: " + salario;
                    encontrado = true;
                }
            }

            if (encontrado){
                System.out.println("Empleado con salario mayor que " + s + ":");
                System.out.println(empleadoMayorSalario);
            } else {
                System.out.println("No hay empleado con salario mayor a " + s);
            }

        } catch(IOException ex){
            ex.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) {
        Empleado e1 = new Empleado("Juan Perez", 30, 2500.0f);
        Empleado e2 = new Empleado("Maria Lopez", 40, 3000.0f);
        Empleado e3 = new Empleado("Carlos Diaz", 28, 2200.0f);
        ArchivoEmpleado arch = new ArchivoEmpleado("empleados");

        arch.crearArchivo();

        arch.guardarEmpleado(e1);
        arch.guardarEmpleado(e2);
        arch.guardarEmpleado(e3);

        System.out.println();
        arch.buscarEmpleado("Maria Lopez");

        System.out.println();
        arch.mayorSalario(2600.0f);
    }
}
