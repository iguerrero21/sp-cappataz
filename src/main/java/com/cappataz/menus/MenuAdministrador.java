package main.java.com.cappataz.menus;

import main.java.com.cappataz.funciones.AnimalFunctions;
import main.java.com.cappataz.funciones.UsuarioFunctions;
import main.java.com.cappataz.funciones.PropiedadFunctions;
import main.java.com.cappataz.modelo.Administrador;

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
            System.out.println("5. Registrar nueva propiedad");
            System.out.println("6. Crear parcelas en una propiedad");
            System.out.println("7. Visualizar todas las propiedades");
            System.out.println("8. Seleccionar una propiedad para ver sus parcelas");
            System.out.println("9. Salir");
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
                    UsuarioFunctions.registrarUsuario();
                    break;
                case 4:
                    UsuarioFunctions.mostrarUsuarios();
                    break;
                case 5:
                    PropiedadFunctions.registrarPropiedad();
                    break;
                case 6:
                    PropiedadFunctions.crearParcelas();
                    break;
                case 7:
                    PropiedadFunctions.mostrarPropiedades();
                    break;
                case 8:
                    PropiedadFunctions.verParcelasDePropiedad();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        scanner.close();
    }
}
