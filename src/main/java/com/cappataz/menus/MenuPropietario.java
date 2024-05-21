package main.java.com.cappataz.menus;

import main.java.com.cappataz.modelo.Propietario;
import main.java.com.cappataz.functions.AnimalFunctions;

import java.util.Scanner;

public class MenuPropietario {
    private Propietario propietario;

    public MenuPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenú Propietario:");
            System.out.println("1. Mostrar todos los animales");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    AnimalFunctions.mostrarAnimales();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        scanner.close();
    }
}
