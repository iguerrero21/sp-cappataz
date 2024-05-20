package main.java.com.cappataz.controlador;

import main.java.com.cappataz.modelo.Usuario;
import main.java.com.cappataz.vista.UsuarioView;

public class UsuarioController {
    private Usuario model;
    private UsuarioView view;

    public UsuarioController(Usuario model, UsuarioView view) {
        this.model = model;
        this.view = view;
    }

    public void saveUsuario() {
        model.setId(view.getId());
        model.setNombre(view.getNombre());
        model.setEmail(view.getEmail());
        model.setRol(view.getRol());
        view.displayUsuarioDetails(model.getNombre(), model.getEmail(), model.getRol());
    }
}