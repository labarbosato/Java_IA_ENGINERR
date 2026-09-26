import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        do{
            Menu.mostrarMenu();
            int opcion = Menu.leerOpcion(sc);
            switch (opcion) {
                case 1:
                    if (!Operaciones.hayCupoDisponible()) {
                        System.out.println("No hay cupo disponible para agendar más citas.");
                        break;
                    }
                    System.out.print("Ingrese su nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese la hora de la cita (8-17): ");
                    int hora = sc.nextInt();
                    System.out.print("Ingrese el servicio del 1 al 3: ");
                    int servicio = sc.nextInt();
                    boolean citaAgendada = Operaciones.agendarCita(nombre, hora, servicio);
                    if (citaAgendada) {
                        System.out.println("Cita agendada exitosamente para " + nombre + " a las " + hora + " horas para el servicio " + servicio + ".");
                    } else {
                        System.out.println("No se pudo agendar la cita. Valide su infomración e intente nuevamente.");
                    }
                    break;
                case 2:
                    Operaciones.listarCitas();
                    break;
                case 3:
                    Operaciones.reportes();
                    break;
                case 4:
                    System.out.println("Cancelando una reserva...");
                    System.out.print("Ingrese el número de la reserva a cancelar: ");
                    int numeroReserva = sc.nextInt();
                    Operaciones.cancelarCita(numeroReserva);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (continuar);
        sc.close();
    }
    
}
