public class Operaciones {
    static final int MAX_CITAS = 10;
    static String [] clientes = new String[MAX_CITAS];
    static int [] horas = new int[MAX_CITAS];
    static int [] servicios = new int[MAX_CITAS];
    static int contadorCitas = 0;

    public static String nombreServicio(int codigo){
        switch (codigo) {
            case 1:
                return "Corte de cabello";
            case 2:
                return "Tinte";
            case 3:
                return "Manicure";
            default:
                return "Servicio desconocido";
        }
    }

    public static boolean horaOcupada(int hora) {
        for (int i = 0; i < contadorCitas; i++) {
            if (horas[i] == hora) {
                return true;
            }
        }
        return false;
    }

    public static boolean hayCupoDisponible() {
        return contadorCitas < MAX_CITAS;
    }

    public static boolean agendarCita(String nombre, int hora, int servicio) {
        if (contadorCitas >= MAX_CITAS) {
            System.out.println("Se ha alcanzado el número máximo de citas.");
            return false;
        }
        if (!Validador.nombreValido(nombre)) {
            System.out.println("Nombre inválido. Por favor, ingrese un nombre válido.");
            return false;
        }
        if (!Validador.horaValida(hora)) {
            System.out.println("Hora inválida. Por favor, ingrese una hora entre 8 y 17.");
            return false;
        }
        if (!Validador.servicioValido(servicio)) {
            System.out.println("Servicio inválido. Por favor, ingrese un servicio entre 1 y 3.");
            return false;
        }
        if (horaOcupada(hora)) {
            System.out.println("La hora " + hora + " ya está ocupada. Por favor, elija otra hora.");
            return false;
        }
        clientes[contadorCitas] = nombre;
        horas[contadorCitas] = hora;
        servicios[contadorCitas] = servicio;
        contadorCitas++;
        return true;
    }

    public static boolean listarCitas() {
        if (contadorCitas == 0) {
            System.out.println("Aún no hay reservas");
            return false;
        }
        System.out.println("=== Listado de Citas ===");
        for (int i = 0; i < contadorCitas; i++) {
            System.out.println("Cita " + (i + 1) + ": " + clientes[i] + " - Hora: " + horas[i] + " - Servicio: " + nombreServicio(servicios[i]));
        }
        return true;
    }

    public static boolean cancelarCita(int numeroReserva){
        int indice = numeroReserva - 1;
        if (indice < 0 || indice >= contadorCitas) {
            System.out.println("Número de reserva inválido. Por favor, ingrese un número válido. Debe de ser un numero entre 1 y " + contadorCitas  + ".");
            return false;
        }

        for (int j = indice; j < contadorCitas - 1; j++) {
            clientes[j] = clientes[j + 1];
            horas[j] = horas[j + 1];
            servicios[j] = servicios[j + 1];
        }
        contadorCitas--;
        return true;
    }

    public static int precioServicio(int codigoServicio) {
        switch (codigoServicio) {
            case 1:
                return 25000;
            case 2:
                return 60000;
            case 3:
                return 30000;
            default:
                return 0;
        }
    }

    public static boolean reportes(){
        if (contadorCitas == 0){
            System.out.println("Aún no hay reservas");
            return false;
        }
        System.out.println("=== Reporte de Citas ===");
        int totalRecaudado = 0;
        for (int i = 0; i < contadorCitas; i++) {
            int precio = precioServicio(servicios[i]);
            totalRecaudado += precio;
            System.out.println("Cita " + (i + 1) + ": " + clientes[i] + " - Hora: " + horas[i] + " - Servicio: " + nombreServicio(servicios[i]) + " - Precio: $" + precio);
        }
        System.out.println("Total de citas agendadas: " + contadorCitas);
        System.out.println("Total recaudado: $" + totalRecaudado);
        return true;
    }

}
