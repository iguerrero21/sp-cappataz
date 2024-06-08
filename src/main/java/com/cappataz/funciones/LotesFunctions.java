package main.java.com.cappataz.funciones;

import main.java.com.cappataz.controlador.LoteController;
import main.java.com.cappataz.modelo.Lote;
import main.java.com.cappataz.vista.LoteView;

public class LotesFunctions {

    public static void mostrarLotes() {
        LoteView loteView = new LoteView();
        LoteController loteController = new LoteController(new Lote(0, "", 0, 0, null), loteView);
        loteController.mostrarTodosLosLotes();

        int idLote = loteView.seleccionarLote();
        loteController.mostrarAnimalesPorLote(idLote);
    }
}
