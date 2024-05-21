package main.java.com.cappataz;

import main.java.com.cappataz.controlador.UsuarioController;
import main.java.com.cappataz.menus.MenuAdministrador;
import main.java.com.cappataz.menus.MenuOperario;
import main.java.com.cappataz.menus.MenuPropietario;
import main.java.com.cappataz.modelo.Administrador;
import main.java.com.cappataz.modelo.Operario;
import main.java.com.cappataz.modelo.Propietario;
import main.java.com.cappataz.modelo.Usuario;
import main.java.com.cappataz.vista.UsuarioView;

public class Main {
    public static void main(String[] args) throws Exception {
        UsuarioView usuarioView = new UsuarioView();
        UsuarioController usuarioController = new UsuarioController(null, usuarioView);

        Usuario usuario = null;
        while (usuario == null) {
            usuario = usuarioController.login();
        }

        switch (usuario.getIdRol()) {
            case 1:
                MenuAdministrador menuAdministrador = new MenuAdministrador((Administrador) usuario);
                menuAdministrador.mostrarMenu();
                break;
            case 2:
                MenuPropietario menuPropietario = new MenuPropietario((Propietario) usuario);
                menuPropietario.mostrarMenu();
                break;
            case 3:
                MenuOperario menuOperario = new MenuOperario((Operario) usuario);
                menuOperario.mostrarMenu();
                break;
            default:
                System.out.println("Rol no reconocido.");
                break;
        }
    }
}
