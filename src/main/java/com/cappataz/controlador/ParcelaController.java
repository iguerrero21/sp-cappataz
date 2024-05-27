package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.ParcelaDAO;
import main.java.com.cappataz.modelo.Parcela;
import main.java.com.cappataz.vista.ParcelaView;

import java.util.List;

public class ParcelaController {
    private Parcela model;
    private ParcelaView view;
    private ParcelaDAO dao;

    public ParcelaController(Parcela model, ParcelaView view) {
        this.model = model;
        this.view = view;
        this.dao = new ParcelaDAO();
    }

    public void saveParcela() {
        dao.saveParcela(model);
        view.mostrarDetallesParcelas(model);
    }

    public void displayParcelasByPropiedad(int idPropiedad) {
        List<Parcela> parcelas = dao.getParcelasByPropiedad(idPropiedad);
        view.mostrarTodasLasParcelas(parcelas);
    }
}
