import java.io.*;
import java.util.ArrayList;

public class ArchFarmacia {
    private String na;
    private File archivo;

    public ArchFarmacia(String na) {
        this.na = na;
        this.archivo = new File(na + ".txt");
    }

    public void crearArchivo() {
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionar(Farmacia f) {
        try (FileWriter fw = new FileWriter(archivo, true)) {
            fw.write(f.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while (br.ready()) {
                Farmacia f = Farmacia.fromBufferedReader(br);
                f.mostrar();
                System.out.println("============");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void mostrarMedicamentosTos(int x) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while (br.ready()) {
                Farmacia f = Farmacia.fromBufferedReader(br);
                if (f.getSucursal() == x) {
                    f.mostrarMedicamentos("tos");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void mostrarSucursalGolpex() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while (br.ready()) {
                Farmacia f = Farmacia.fromBufferedReader(br);
                if (f.buscaMedicamento("Golpex")) {
                    System.out.println("Sucursal: " + f.getSucursal());
                    System.out.println("Dirección: " + f.getDireccion());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArchFarmacia arch = new ArchFarmacia("farmacias");
        arch.crearArchivo();


        Medicamento m1 = new Medicamento("Golpex", 100, "tos", 12.5);
        Medicamento m2 = new Medicamento("Paracetamol", 101, "fiebre", 5.0);
        Medicamento m3 = new Medicamento("Vitamina C", 102, "resfrio", 7.0);

        Farmacia f1 = new Farmacia();
        f1.leer("Farmacia Central", 1, "Av. Siempre Viva 123");
        f1.adicionarMedicamento(m1);
        f1.adicionarMedicamento(m2);

        Farmacia f2 = new Farmacia();
        f2.leer("Farmacia Sur", 2, "Calle Falsa 456");
        f2.adicionarMedicamento(m3);

        arch.adicionar(f1);
        arch.adicionar(f2);

        System.out.println("\n=== Listar todas las farmacias ===");
        arch.listar();

        System.out.println("\n=== Medicamentos para la tos en sucursal 1 ===");
        arch.mostrarMedicamentosTos(1);

        System.out.println("\n=== Sucursales que tienen 'Golpex' ===");
        arch.mostrarSucursalGolpex();
    }
}
