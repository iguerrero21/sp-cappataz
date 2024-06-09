package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.EventoSanitarioDAO;
import main.java.com.cappataz.dao.AnimalDAO;
import main.java.com.cappataz.modelo.EventoSanitario;
import main.java.com.cappataz.modelo.Animal;
import main.java.com.cappataz.vista.EventoSanitarioView;

import java.util.List;

public class EventoSanitarioController {
    private EventoSanitarioView view;
    private EventoSanitarioDAO dao;
    private AnimalDAO animalDao;

    public EventoSanitarioController(EventoSanitarioView view) {
        this.view = view;
        this.dao = new EventoSanitarioDAO();
        this.animalDao = new AnimalDAO();
    }

    public void registrarEventoSanitario() {
        EventoSanitario evento = view.obtenerDatosEventoSanitario();
        dao.saveEventoSanitario(evento);
        view.mostrarEventoSanitario(evento);
    }

    public void registrarEventoSanitarioAnimal() {
        EventoSanitario evento = view.obtenerDatosEventoSanitario();
        evento.setIdAnimal(view.getIdAnimal()); // Asignar idAnimal específico
        dao.saveEventoSanitario(evento);
        view.mostrarEventoSanitario(evento);
    }

    public void registrarEventoSanitarioLote() {
        int idLote = view.getIdLote(); // Obtener el ID del lote específico
        List<Animal> animales = animalDao.getAnimalesPorLote(idLote); // Obtener todos los animales en el lote

        for (Animal animal : animales) {
            EventoSanitario evento = view.obtenerDatosEventoSanitario();
            evento.setIdAnimal(animal.getId()); // Asignar idAnimal de cada animal en el lote
            evento.setIdLote(idLote); // Asignar idLote
            dao.saveEventoSanitario(evento);
            view.mostrarEventoSanitario(evento);
        }
    }

    public void mostrarEventosSanitariosLote(int idLote) {
        List<EventoSanitario> eventos = dao.getEventosSanitariosPorLote(idLote);
        view.mostrarDetallesDeTodosLosEventos(eventos);
    }

    public void mostrarEventosSanitariosAnimal(int idAnimal) {
        List<EventoSanitario> eventos = dao.getEventosSanitariosPorAnimal(idAnimal);
        view.mostrarDetallesDeTodosLosEventos(eventos);
    }

    public void mostrarEventosSanitarios() {
        List<EventoSanitario> eventos = dao.getAllEventosSanitarios();
        view.mostrarDetallesDeTodosLosEventos(eventos);
    }

    public void modificarEventoSanitario() {
        int idSanidad = view.getIdSanidad();
        EventoSanitario evento = dao.getEventoSanitarioById(idSanidad);
        if (evento != null) {
            EventoSanitario nuevosDatos = view.obtenerDatosEventoSanitario();
            nuevosDatos.setIdSanidad(idSanidad); // Asegurarse de mantener el mismo ID
            dao.updateEventoSanitario(nuevosDatos);
            view.mostrarEventoSanitario(nuevosDatos);
        } else {
            view.mostrarMensaje("Evento Sanitario no encontrado.");
        }
    }

    public void eliminarEventoSanitario() {
        int idSanidad = view.getIdSanidad();
        dao.deleteEventoSanitario(idSanidad);
        view.mostrarMensaje("Evento Sanitario eliminado exitosamente.");
    }
}
