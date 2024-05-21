package main.java.com.cappataz.menus;

import main.java.com.cappataz.modelo.Administrador;
import main.java.com.cappataz.functions.AnimalFunctions;
import main.java.com.cappataz.functions.UserFunctions;

import java.util.Scanner;

public class MenuAdministrador {
    private Administrador admin;

    public MenuAdministrador(Administrador admin) {
        this.admin = admin;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenú Administrador:");
            System.out.println("1. Registrar nuevo animal");
            System.out.println("2. Mostrar todos los animales");
            System.out.println("3. Registrar nuevo usuario");
            System.out.println("4. Mostrar todos los usuarios");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    AnimalFunctions.registrarAnimal();
                    break;
                case 2:
                    AnimalFunctions.mostrarAnimales();
                    break;
                case 3:
                    UserFunctions.registrarUsuario();
                    break;
                case 4:
                    UserFunctions.mostrarUsuarios();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        scanner.close();
    }
}
