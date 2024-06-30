package main.java.com.cappataz.menus;

import main.java.com.cappataz.funciones.AnimalFunctions;
import main.java.com.cappataz.funciones.LotesFunctions;
import main.java.com.cappataz.util.InputValidator;
import main.java.com.cappataz.vista.LoteView;
import main.java.com.cappataz.modelo.Operario;

import java.util.Scanner;

public class MenuOperario {
    private Operario operario;

    public MenuOperario(Operario operario) {
        this.operario = operario;
    }

    public void mostrarMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("\nMenú Operario:");
                System.out.println("1. Gestionar animales");
                System.out.println("2. Gestionar lotes");
                System.out.println("3. Registrar evento sanitario");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                int choice = InputValidator.obtenerEntradaValida(scanner);

                switch (choice) {
                    case 1:
                        gestionarAnimales(scanner);
                        break;
                    case 2:
                        gestionarLotes(scanner);
                        break;
                    case 3:
                        registrarEventoSanitario(scanner);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            }
        }
    }

    private void gestionarAnimales(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\nGestionar Animales:");
            System.out.println("1. Registrar nuevo animal");
            System.out.println("2. Mostrar lotes");
            System.out.println("3. Volver al menú inicial");
            System.out.print("Seleccione una opción: ");
            int choice = InputValidator.obtenerEntradaValida(scanner);

            switch (choice) {
                case 1:
                    AnimalFunctions.registrarAnimal();
                    break;
                case 2:
                    LotesFunctions.mostrarLotes();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private void gestionarLotes(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\nGestionar Lotes:");
            System.out.println("1. Registrar nuevo lote");
            System.out.println("2. Modificar lote");
            System.out.println("3. Eliminar lote");
            System.out.println("4. Volver al menú inicial");
            System.out.print("Seleccione una opción: ");
            int choice = InputValidator.obtenerEntradaValida(scanner);

            switch (choice) {
                case 1:
                    LotesFunctions.registrarLote();
                    break;
                case 2:
                    LotesFunctions.modificarLote();
                    break;
                case 3:
                    LotesFunctions.eliminarLote();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private void registrarEventoSanitario(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\nRegistrar Evento Sanitario:");
            System.out.println("1. Evento sanitario por lote");
            System.out.println("2. Evento sanitario individual");
            System.out.println("3. Volver al menú inicial");
            System.out.print("Seleccione una opción: ");
            int choice = InputValidator.obtenerEntradaValida(scanner);

            switch (choice) {
                case 1:
                    LotesFunctions.mostrarLotesConAnimales(); // Mostrar lotes con animales
                    LotesFunctions.registrarEventoSanitarioLote();
                    break;
                case 2:
                    AnimalFunctions.registrarEventoSanitarioAnimal();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}
