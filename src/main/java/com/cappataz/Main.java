package main.java.com.cappataz;

import main.java.com.cappataz.controlador.UsuarioController;
import main.java.com.cappataz.modelo.Usuario;
import main.java.com.cappataz.vista.UsuarioView;

public class Main {
    public static void main(String[] args) throws Exception {
        Usuario model = new Usuario(0, "", "", "");
        UsuarioView view = new UsuarioView();
        UsuarioController controller = new UsuarioController(model, view);

        controller.saveUsuario();
    }
}
