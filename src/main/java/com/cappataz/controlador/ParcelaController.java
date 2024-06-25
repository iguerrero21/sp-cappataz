package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.ParcelaDAO;
import main.java.com.cappataz.modelo.Parcela;
import main.java.com.cappataz.vista.ParcelaView;

import java.util.List;

public class ParcelaController {
    private ParcelaView view;
    private ParcelaDAO dao;

    public ParcelaController(ParcelaView view) {
        this.view = view;
        this.dao = new ParcelaDAO();
    }

    public List<Parcela> getParcelasByPropiedad(int idPropiedad) {
        return dao.getParcelasByPropiedad(idPropiedad);
    }

    public void saveParcela(Parcela parcela) {
        dao.saveParcela(parcela);
    }

    public void registrarParcela() {
        Parcela parcela = view.obtenerDatosParcela();
        saveParcela(parcela);
        view.mostrarMensaje("Parcela registrada exitosamente.");
    }

    public void displayParcelasByPropiedad(int idPropiedad) {
        List<Parcela> parcelas = getParcelasByPropiedad(idPropiedad);
        view.mostrarParcelas(parcelas);
    }
}
