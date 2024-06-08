package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.UsuarioDAO;
import main.java.com.cappataz.modelo.IUsuario;
import main.java.com.cappataz.vista.UsuarioView;

public class UsuarioController {
    private IUsuario model;
    private UsuarioView view;
    private UsuarioDAO dao;

    public UsuarioController(IUsuario model, UsuarioView view) {
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
        view.mostrarDetallesUsuario(model);
    }

    public IUsuario login() {
        String email;
        String contrasena;
        IUsuario usuario = null;

        while (usuario == null) {
            email = view.getEmailForLogin();
            contrasena = view.getPasswordForLogin();
            usuario = dao.getUsuarioByEmailAndPassword(email, contrasena);
            if (usuario != null) {
                view.mostrarLogueoExitoso(usuario.getNombre());
            } else {
                view.mostrarErrorLogueo();
            }
        }
        return usuario;
    }
}
