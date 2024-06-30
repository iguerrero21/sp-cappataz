package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.UsuarioDAO;
import main.java.com.cappataz.modelo.IUsuario;
import main.java.com.cappataz.vista.UsuarioView;

import java.util.List;

public class UsuarioController {
    private IUsuario model;
    private UsuarioView view;
    private UsuarioDAO dao;

    public UsuarioController(IUsuario model, UsuarioView view) {
        this.model = model;
        this.view = view;
        this.dao = new UsuarioDAO();
    }

    public void saveUsuario(int idRol) {
        model.setNombre(view.getNombre());
        model.setApellido(view.getApellido());
        model.setEmail(view.getEmail());
        model.setContrasena(view.getPasswordForLogin()); // Guardar la contraseña antes de hashear
        model.setIdRol(idRol);
        dao.saveUsuario(model);
        view.mostrarDetallesUsuario(model);
    }

    public IUsuario login() {
        String email = view.getEmailForLogin();
        String contrasena = view.getPasswordForLogin();
        IUsuario usuario = dao.getUsuarioByEmailAndPassword(email, contrasena);
        if (usuario != null) {
            view.mostrarLogueoExitoso(usuario.getNombre());
        } else {
            view.mostrarErrorLogueo();
        }
        return usuario;
    }

    public void displayAllUsuarios() {
        List<IUsuario> usuarios = dao.getAllUsuarios();
        view.mostrarTodosLosUsuarios(usuarios);
    }

    public void displayUsuariosByRole(int roleId) {
        List<IUsuario> usuarios;
        if (roleId == 0) {
            usuarios = dao.getAllUsuarios();
        } else {
            usuarios = dao.getUsuariosByRole(roleId);
        }
        view.mostrarTodosLosUsuarios(usuarios);
    }

    public void deleteUsuario() {
        int idUsuario = view.getIdUsuario();
        dao.deleteUsuario(idUsuario);
        view.mostrarMensaje("Usuario eliminado con éxito.");
    }
}
