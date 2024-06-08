package main.java.com.cappataz.funciones;

import java.util.List;
import java.util.Scanner;

import main.java.com.cappataz.controlador.UsuarioController;
import main.java.com.cappataz.dao.UsuarioDAO;
import main.java.com.cappataz.modelo.Administrador;
import main.java.com.cappataz.modelo.Propietario;
import main.java.com.cappataz.vista.UsuarioView;

public class UsuarioFunctions {

    public static void registrarUsuario() {
        UsuarioView nuevoUsuarioView = new UsuarioView();
        Administrador nuevoUsuario = new Administrador(0, "", "", "", "");
        UsuarioController nuevoUsuarioController = new UsuarioController(nuevoUsuario, nuevoUsuarioView);
        nuevoUsuarioController.saveUsuario();
    }

    public static void mostrarUsuarios() {
        // Implementar lógica para mostrar todos los usuarios
    }


    public static Propietario seleccionarPropietario() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Propietario> propietarios = usuarioDAO.getPropietarios();

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("\nLista de Propietarios:");
            for (int i = 0; i < propietarios.size(); i++) {
                System.out.printf("%d. %s %s\n", i + 1, propietarios.get(i).getNombre(), propietarios.get(i).getApellido());
            }

            System.out.print("Seleccione un propietario por número: ");
            int choice = scanner.nextInt();

            if (choice < 1 || choice > propietarios.size()) {
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
                return null;
            }

            return propietarios.get(choice - 1);
        }
    }    
}
