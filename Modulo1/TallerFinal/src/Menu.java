import java.util.Scanner;

public class Menu {
    public static void mostrarMenu() {
        System.out.println("=== Menú de Opciones ===");
        System.out.println("1. Agendar Cita");
        System.out.println("2. Listar Citas");
        System.out.println("3. Reportes");
        System.out.println("4. Cancelar una reserva");
        System.out.println("5. Salir del programa");
    }

    public static int leerOpcion(Scanner sc) {
        System.out.print("Ingrese una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;

    }
}


