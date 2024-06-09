package main.java.com.cappataz.menus;

import main.java.com.cappataz.funciones.AnimalFunctions;
import main.java.com.cappataz.funciones.UsuarioFunctions;
import main.java.com.cappataz.funciones.PropiedadFunctions;
import main.java.com.cappataz.funciones.LotesFunctions;
import main.java.com.cappataz.modelo.Administrador;
import main.java.com.cappataz.util.InputValidator;

import java.util.Scanner;

public class MenuAdministrador {
    private Administrador admin;

    public MenuAdministrador(Administrador admin) {
        this.admin = admin;
    }

    public void mostrarMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("\nMenú Administrador:");
                System.out.println("1. Gestionar usuarios");
                System.out.println("2. Gestionar propiedades");
                System.out.println("3. Gestionar animales");
                System.out.println("4. Gestionar lotes");
                System.out.println("5. Registrar evento sanitario");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                int choice = InputValidator.obtenerEntradaValida(scanner);

                switch (choice) {
                    case 1:
                        gestionarUsuarios(scanner);
                        break;
                    case 2:
                        gestionarPropiedades(scanner);
                        break;
                    case 3:
                        gestionarAnimales(scanner);
                        break;
                    case 4:
                        gestionarLotes(scanner);
                        break;
                    case 5:
                        registrarEventoSanitario(scanner);
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            }
        }
    }

    private void gestionarUsuarios(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\nGestionar Usuarios:");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Mostrar todos los usuarios");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Volver al menú inicial");
            System.out.print("Seleccione una opción: ");
            int choice = InputValidator.obtenerEntradaValida(scanner);

            switch (choice) {
                case 1:
                    UsuarioFunctions.registrarUsuario();
                    break;
                case 2:
                    UsuarioFunctions.mostrarUsuarios();
                    break;
                case 3:
                    UsuarioFunctions.eliminarUsuario();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private void gestionarPropiedades(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\nGestionar Propiedades:");
            System.out.println("1. Registrar nueva propiedad");
            System.out.println("2. Ver propiedades");
            System.out.println("3. Volver al menú inicial");
            System.out.print("Seleccione una opción: ");
            int choice = InputValidator.obtenerEntradaValida(scanner);

            switch (choice) {
                case 1:
                    PropiedadFunctions.registrarPropiedad();
                    break;
                case 2:
                    PropiedadFunctions.mostrarPropiedadesPaginado();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
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
