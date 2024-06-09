package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.EventoSaludDAO;
import main.java.com.cappataz.modelo.EventoSalud;
import main.java.com.cappataz.vista.EventoSaludView;

public class EventoSaludController {
    private EventoSaludDAO dao;
    private EventoSaludView view;

    public EventoSaludController(EventoSaludView view) {
        this.dao = new EventoSaludDAO();
        this.view = view;
    }

    public void registrarEventoSalud() {
        EventoSalud evento = view.obtenerDatosEventoSalud();
        dao.saveEventoSalud(evento);
        view.mostrarEventoSaludRegistrado(evento);
    }

    // Otros métodos para update, delete, get, etc.
}
