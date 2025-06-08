import java.io.*;

public class ArchivoCliente {
    private String nomA;
    private File archivo;

    public ArchivoCliente(String n) {
        this.nomA = n;
    }

    public void crearArchivo() {
        archivo = new File(nomA + ".txt");
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado con éxito.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void guardaCliente(Cliente c) {
        try (FileWriter fw = new FileWriter(archivo, true)) {
            fw.write(c.getId() + "\n");
            fw.write(c.getNombre() + "\n");
            fw.write(c.getTelefono() + "\n");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

   
    public Cliente buscarCliente(int c) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int id = Integer.parseInt(linea);
                String nombre = br.readLine();
                int telefono = Integer.parseInt(br.readLine());

                if (id == c) {
                    return new Cliente(id, nombre, telefono);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

  
    public void buscarCelularCliente(int c) {
        Cliente encontrado = buscarCliente(c);
        if (encontrado != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(encontrado.toString());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static void main(String[] args) {
        ArchivoCliente arch = new ArchivoCliente("clientes");
        arch.crearArchivo();

        Cliente cli1 = new Cliente(1, "Ana Torres", 5551234);
        Cliente cli2 = new Cliente(2, "Luis Gómez", 5555678);
        Cliente cli3 = new Cliente(3, "Sofía Pérez", 5559012);

        arch.guardaCliente(cli1);
        arch.guardaCliente(cli2);
        arch.guardaCliente(cli3);

        System.out.println("\nBuscando cliente con ID 2:");
        Cliente buscado = arch.buscarCliente(2);
        if (buscado != null) {
            System.out.println(buscado);
        }

        System.out.println("\nBuscando celular de cliente con ID 3:");
        arch.buscarCelularCliente(3);
    }
}
