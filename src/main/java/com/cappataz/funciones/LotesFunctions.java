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

    public static void mostrarLotesConAnimales() {
        LoteView loteView = new LoteView();
        LoteController loteController = new LoteController(null, loteView);
        loteController.mostrarLotesConAnimales();
    }

    public static void registrarLote() {
        LoteView loteView = new LoteView();
        LoteController loteController = new LoteController(null, loteView);
        loteController.registrarLote();
    }

    public static void modificarLote() {
        LoteView loteView = new LoteView();
        LoteController loteController = new LoteController(null, loteView);
        loteController.actualizarLote();
    }

    public static void eliminarLote() {
        LoteView loteView = new LoteView();
        LoteController loteController = new LoteController(null, loteView);
        loteController.eliminarLote();
    }

    public static void mostrarLotePorId() {
        LoteView loteView = new LoteView();
        LoteController loteController = new LoteController(null, loteView);
        loteController.seleccionarLote();
    }

    public static void registrarEventoSanitarioLote() {
        LoteView loteView = new LoteView();
        LoteController loteController = new LoteController(null, loteView);
        loteController.registrarEventoSanitarioLote();
    }

    public static void mostrarEventosSanitariosLote() {
        LoteView loteView = new LoteView();
        LoteController loteController = new LoteController(null, loteView);
        loteController.mostrarEventoSanitarioLote();
    }
}
