package main.java.com.cappataz.menus;

import main.java.com.cappataz.funciones.AnimalFunctions;
import main.java.com.cappataz.modelo.Operario;

import java.util.Scanner;

public class MenuOperario {
    private Operario operario;

    public MenuOperario(Operario operario) {
        this.operario = operario;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenú Operario:");
            System.out.println("1. Registrar nuevo animal");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    AnimalFunctions.registrarAnimal();
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
