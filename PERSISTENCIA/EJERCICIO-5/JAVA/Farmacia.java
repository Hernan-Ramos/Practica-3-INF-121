public class Farmacia {
    private String nombreFarmacia;
    private int sucursal;
    private String direccion;
    private int nroMedicamentos;
    private Medicamento[] m = new Medicamento[100];

    public Farmacia() {
        nroMedicamentos = 0;
    }

    public void leer(String nombreF, int suc, String dir) {
        nombreFarmacia = nombreF;
        sucursal = suc;
        direccion = dir;
    }

    public void adicionarMedicamento(Medicamento med) {
        m[nroMedicamentos++] = med;
    }

    public void mostrar() {
        System.out.println("Farmacia: " + nombreFarmacia);
        System.out.println("Sucursal: " + sucursal);
        System.out.println("Dirección: " + direccion);
        System.out.println("Medicamentos:");
        for (int i = 0; i < nroMedicamentos; i++) {
            m[i].mostrar();
            System.out.println("-----");
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void mostrarMedicamentos(String tipoBuscado) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getTipo().equalsIgnoreCase(tipoBuscado)) {
                m[i].mostrar();
            }
        }
    }

    public boolean buscaMedicamento(String nombreBuscado) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getNombre().equalsIgnoreCase(nombreBuscado)) {
                return true;
            }
        }
        return false;
    }

    public String toFileString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombreFarmacia).append("\n")
                .append(sucursal).append("\n")
                .append(direccion).append("\n")
                .append(nroMedicamentos).append("\n");
        for (int i = 0; i < nroMedicamentos; i++) {
            sb.append(m[i].toFileString()).append("\n");
        }
        return sb.toString();
    }

    public static Farmacia fromBufferedReader(java.io.BufferedReader br) throws java.io.IOException {
        Farmacia f = new Farmacia();
        f.nombreFarmacia = br.readLine();
        f.sucursal = Integer.parseInt(br.readLine());
        f.direccion = br.readLine();
        f.nroMedicamentos = Integer.parseInt(br.readLine());
        for (int i = 0; i < f.nroMedicamentos; i++) {
            String nom = br.readLine();
            int cod = Integer.parseInt(br.readLine());
            String tipo = br.readLine();
            double precio = Double.parseDouble(br.readLine());
            f.m[i] = new Medicamento(nom, cod, tipo, precio);
        }
        return f;
    }
}
