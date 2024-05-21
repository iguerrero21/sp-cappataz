package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.UsuarioDAO;
import main.java.com.cappataz.modelo.Usuario;
import main.java.com.cappataz.vista.UsuarioView;

public class UsuarioController {
    private Usuario model;
    private UsuarioView view;
    private UsuarioDAO dao;

    public UsuarioController(Usuario model, UsuarioView view) {
        this.model = model;
        this.view = view;
        this.dao = new UsuarioDAO();
    }

    public void saveUsuario() {
        model.setNombre(view.getNombre());
        model.setApellido(view.getApellido());
        model.setEmail(view.getEmail());
        model.setContrasena(view.getPasswordForLogin()); // Guardar la contraseña antes de hashear
        model.setIdRol(view.getIdRol());
        dao.saveUsuario(model);
        view.displayUsuarioDetails(model);
    }

    public Usuario login() {
        String email = view.getEmailForLogin();
        String contrasena = view.getPasswordForLogin();
        Usuario usuario = dao.getUsuarioByEmailAndPassword(email, contrasena);
        if (usuario != null) {
            view.displayLoginSuccess(usuario.getNombre());
        } else {
            view.displayLoginFailure();
        }
        return usuario;
    }
}
