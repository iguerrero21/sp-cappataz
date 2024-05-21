package main.java.com.cappataz.funciones;

import main.java.com.cappataz.controlador.UsuarioController;
import main.java.com.cappataz.modelo.Administrador;
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
}
