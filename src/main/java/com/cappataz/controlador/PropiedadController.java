package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.PropiedadDAO;
import main.java.com.cappataz.modelo.Propiedad;
import main.java.com.cappataz.vista.PropiedadView;

import java.util.List;

public class PropiedadController {
    private Propiedad model;
    private PropiedadView view;
    private PropiedadDAO dao;

    public PropiedadController(Propiedad model, PropiedadView view) {
        this.model = model;
        this.view = view;
        this.dao = new PropiedadDAO();
    }

    public void savePropiedad() {
        dao.savePropiedad(model);
        view.displayPropiedadDetails(model);
    }

    public void displayAllPropiedades() {
        List<Propiedad> propiedades = dao.getAllPropiedades();
        view.displayAllPropiedades(propiedades);
    }
}
