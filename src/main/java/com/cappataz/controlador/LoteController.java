package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.AnimalDAO;
import main.java.com.cappataz.dao.EventoSanitarioDAO;
import main.java.com.cappataz.dao.LoteDAO;
import main.java.com.cappataz.modelo.Animal;
import main.java.com.cappataz.modelo.EventoSanitario;
import main.java.com.cappataz.modelo.Lote;
import main.java.com.cappataz.vista.AnimalView;
import main.java.com.cappataz.vista.LoteView;
import main.java.com.cappataz.vista.EventoSanitarioView;

import java.util.List;

public class LoteController {
    private Lote model;
    private LoteView view;
    private LoteDAO dao;
    private AnimalDAO animalDao;
    private EventoSanitarioDAO eventoSanitarioDao;
    private EventoSanitarioView eventoSanitarioView;

    public LoteController(Lote model, LoteView view) {
        this.model = model;
        this.view = view;
        this.dao = new LoteDAO();
        this.animalDao = new AnimalDAO();
        this.eventoSanitarioDao = new EventoSanitarioDAO();
        this.eventoSanitarioView = new EventoSanitarioView();
    }

    public void mostrarTodosLosLotes() {
        List<Lote> lotes = dao.getAllLotes();
        view.mostrarLotes(lotes);
    }

    public void seleccionarLote() {
        int idLote = view.seleccionarLote();
        Lote lote = dao.getLoteById(idLote);
        if (lote != null) {
            view.mostrarLote(lote);
        } else {
            view.mostrarMensaje("Lote no encontrado.");
        }
    }

    public void registrarLote() {
        Lote lote = view.obtenerDatosLote();
        dao.saveLote(lote);
        view.mostrarMensaje("Lote registrado exitosamente.");
    }

    public void actualizarLote() {
        int idLote = view.seleccionarLote();
        Lote lote = dao.getLoteById(idLote);
        if (lote != null) {
            Lote datosActualizados = view.obtenerDatosLote();
            lote.setNombre(datosActualizados.getNombre());
            lote.setIdPropietario(datosActualizados.getIdPropietario());
            lote.setIdParcela(datosActualizados.getIdParcela());
            dao.updateLote(lote);
            view.mostrarMensaje("Lote actualizado exitosamente.");
        } else {
            view.mostrarMensaje("Lote no encontrado.");
        }
    }

    public void eliminarLote() {
        int idLote = view.seleccionarLote();
        dao.deleteLote(idLote);
        view.mostrarMensaje("Lote eliminado exitosamente.");
    }

    public void mostrarAnimalesPorLote(int idLote) {
        List<Animal> animales = animalDao.getAnimalesPorLote(idLote);
        AnimalView animalView = new AnimalView();
        animalView.mostrarDetallesdeTodoslosAnimales(animales);
    }

    public void registrarEventoSanitarioLote() {
        int idLote = view.getIdLote();
        List<Animal> animales = animalDao.getAnimalesPorLote(idLote);

        if (!animales.isEmpty()) {
            EventoSanitario datosEvento = eventoSanitarioView.obtenerDatosEventoSanitario();

            for (Animal animal : animales) {
                EventoSanitario evento = new EventoSanitario();
                evento.setIdAnimal(animal.getId());
                evento.setIdLote(idLote);
                evento.setFechaInicio(datosEvento.getFechaInicio());
                evento.setFechaFin(datosEvento.getFechaFin());
                evento.setTratamiento(datosEvento.getTratamiento());
                evento.setResultado(datosEvento.getResultado());
                evento.setIdCategoria(datosEvento.getIdCategoria());
                evento.setIdOperario(datosEvento.getIdOperario());
                eventoSanitarioDao.saveEventoSanitario(evento);
            }
            view.mostrarMensaje("Evento sanitario registrado para todos los animales del lote.");
        } else {
            view.mostrarMensaje("No se encontraron animales en el lote.");
        }
    }

    public void mostrarEventoSanitarioLote() {
        int idLote = view.getIdLote();
        List<EventoSanitario> eventos = eventoSanitarioDao.getEventosSanitariosPorLote(idLote);

        if (!eventos.isEmpty()) {
            eventoSanitarioView.mostrarDetallesDeTodosLosEventos(eventos);
        } else {
            view.mostrarMensaje("No se encontraron eventos sanitarios para el lote.");
        }
    }
}
