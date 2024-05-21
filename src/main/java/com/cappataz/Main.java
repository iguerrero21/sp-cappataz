package main.java.com.cappataz;

import main.java.com.cappataz.controlador.UsuarioController;
import main.java.com.cappataz.controlador.AnimalController;
import main.java.com.cappataz.modelo.Usuario;
import main.java.com.cappataz.modelo.Animal;
import main.java.com.cappataz.vista.UsuarioView;
import main.java.com.cappataz.vista.AnimalView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        UsuarioView usuarioView = new UsuarioView();
        UsuarioController usuarioController = new UsuarioController(new Usuario(0, "", "", "", 0), usuarioView);

        Usuario usuario = null;
        while (usuario == null) {
            usuario = usuarioController.login();
        }

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenú:");
            switch (usuario.getIdRol()) {
                case 1: // Administrador
                    System.out.println("1. Registrar nuevo animal");
                    System.out.println("2. Mostrar todos los animales");
                    System.out.println("3. Registrar nuevo usuario");
                    System.out.println("4. Mostrar todos los usuarios");
                    System.out.println("5. Salir");
                    break;
                case 2: // Propietario
                    System.out.println("1. Mostrar todos los animales");
                    System.out.println("2. Salir");
                    break;
                case 3: // Operario
                    System.out.println("1. Registrar nuevo animal");
                    System.out.println("2. Salir");
                    break;
            }
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (usuario.getIdRol() == 1 || usuario.getIdRol() == 3) {
                        Animal animalModel = new Animal();
                        AnimalView animalView = new AnimalView();
                        AnimalController animalController = new AnimalController(animalModel, animalView);
                        animalController.saveAnimal();
                    } else if (usuario.getIdRol() == 2) {
                        AnimalView animalView = new AnimalView();
                        AnimalController animalController = new AnimalController(new Animal(), animalView);
                        animalController.displayAllAnimals();
                    }
                    break;
                case 2:
                    if (usuario.getIdRol() == 1 || usuario.getIdRol() == 2) {
                        AnimalView animalView = new AnimalView();
                        AnimalController animalController = new AnimalController(new Animal(), animalView);
                        animalController.displayAllAnimals();
                    } else if (usuario.getIdRol() == 3) {
                        exit = true;
                    }
                    break;
                case 3:
                    if (usuario.getIdRol() == 1) {
                        Usuario nuevoUsuario = new Usuario(0, "", "", "", 0);
                        UsuarioView nuevoUsuarioView = new UsuarioView();
                        UsuarioController nuevoUsuarioController = new UsuarioController(nuevoUsuario,
                                nuevoUsuarioView);
                        nuevoUsuarioController.saveUsuario();
                    } else {
                        exit = true;
                    }
                    break;
                case 4:
                    if (usuario.getIdRol() == 1) {
                        // Lógica para mostrar todos los usuarios
                    }
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
