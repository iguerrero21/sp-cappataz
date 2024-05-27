package main.java.com.cappataz.menus;

import main.java.com.cappataz.funciones.AnimalFunctions;
import main.java.com.cappataz.modelo.Propietario;

import java.util.Scanner;

public class MenuPropietario {
    private Propietario propietario;

    public MenuPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void mostrarMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("\nMenú Propietario:");
                System.out.println("1. Mostrar todos mis animales");
                System.out.println("2. Salir");
                System.out.print("Seleccione una opción: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        AnimalFunctions.mostrarAnimalesPorPorpietario(propietario.getIdUsuario());
                        break;
                    case 2:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            }
        }
    }
}
