package main.java.com.cappataz.funciones;

import main.java.com.cappataz.controlador.UsuarioController;
import main.java.com.cappataz.vista.UsuarioView;
import main.java.com.cappataz.util.InputValidator;
import main.java.com.cappataz.dao.UsuarioDAO;
import main.java.com.cappataz.modelo.Propietario;

import java.util.List;
import java.util.Scanner;

public class UsuarioFunctions {
    public static void registrarUsuario() {
        UsuarioView usuarioView = new UsuarioView();
        UsuarioController usuarioController = new UsuarioController(null, usuarioView);
        usuarioController.saveUsuario();
    }

    public static void mostrarUsuarios() {
        UsuarioView usuarioView = new UsuarioView();
        UsuarioController usuarioController = new UsuarioController(null, usuarioView);

        System.out.println("Mostrar usuarios por rol:");
        System.out.println("1. Administradores");
        System.out.println("2. Propietarios");
        System.out.println("3. Operarios");
        System.out.println("4. Todos");
        System.out.print("Seleccione una opción: ");
        int roleId = InputValidator.obtenerEntradaValida(new Scanner(System.in));

        if (roleId < 1 || roleId > 4) {
            System.out.println("Opción no válida.");
            return;
        }

        if (roleId == 4) {
            roleId = 0; // Mostrar todos los usuarios
        }

        usuarioController.displayUsuariosByRole(roleId);

        System.out.println("Presione Enter para continuar...");
        new Scanner(System.in).nextLine(); // Espera a que el usuario presione Enter
    }

    public static void eliminarUsuario() {
        UsuarioView usuarioView = new UsuarioView();
        UsuarioController usuarioController = new UsuarioController(null, usuarioView);
        usuarioController.deleteUsuario();
    }

    
    /** 
     * @return Propietario
     */
    public static Propietario seleccionarPropietario() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Propietario> propietarios = usuarioDAO.getPropietarios();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nLista de Propietarios:");
            for (int i = 0; i < propietarios.size(); i++) {
                System.out.printf("%d. %s %s\n", i + 1, propietarios.get(i).getNombre(),
                        propietarios.get(i).getApellido());
            }

            System.out.print("Seleccione un propietario por número: ");
            int choice = InputValidator.obtenerEntradaValida(scanner);

            if (choice < 1 || choice > propietarios.size()) {
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
                return null;
            }

            return propietarios.get(choice - 1);
        }
    }
}
