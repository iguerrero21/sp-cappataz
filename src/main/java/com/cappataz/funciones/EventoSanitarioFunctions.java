package main.java.com.cappataz.funciones;

import main.java.com.cappataz.controlador.EventoSanitarioController;
import main.java.com.cappataz.vista.EventoSanitarioView;

public class EventoSanitarioFunctions {
    
    public static void registrarEventoSanitarioLote() {
        EventoSanitarioView eventoSanitarioView = new EventoSanitarioView();
        EventoSanitarioController eventoSanitarioController = new EventoSanitarioController(eventoSanitarioView);
        eventoSanitarioController.registrarEventoSanitarioLote();
    }

    public static void registrarEventoSanitarioAnimal() {
        EventoSanitarioView eventoSanitarioView = new EventoSanitarioView();
        EventoSanitarioController eventoSanitarioController = new EventoSanitarioController(eventoSanitarioView);
        eventoSanitarioController.registrarEventoSanitarioAnimal();
    }

    public static void mostrarEventosSanitariosLote() {
        EventoSanitarioView eventoSanitarioView = new EventoSanitarioView();
        EventoSanitarioController eventoSanitarioController = new EventoSanitarioController(eventoSanitarioView);
        eventoSanitarioController.mostrarEventosSanitariosLote();
    }

    public static void mostrarEventosSanitariosAnimal() {
        EventoSanitarioView eventoSanitarioView = new EventoSanitarioView();
        EventoSanitarioController eventoSanitarioController = new EventoSanitarioController(eventoSanitarioView);
        eventoSanitarioController.mostrarEventosSanitariosAnimal();
    }
}
