package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.AnimalDAO;
import main.java.com.cappataz.dao.LoteDAO;
import main.java.com.cappataz.modelo.Animal;
import main.java.com.cappataz.modelo.Lote;
import main.java.com.cappataz.vista.AnimalView;
import main.java.com.cappataz.vista.LoteView;

import java.util.List;

public class LoteController {
    private Lote model;
    private LoteView view;
    private LoteDAO dao;
    private AnimalDAO animalDao;


    public LoteController(Lote model, LoteView view) {
        this.model = model;
        this.view = view;
        this.dao = new LoteDAO();
        this.animalDao = new AnimalDAO();        
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
        Lote lote = new Lote(0, view.getNombreLote(), view.getIdPropietario(), view.getIdParcela(), null);
        dao.saveLote(lote);
        view.mostrarMensaje("Lote registrado exitosamente.");
    }

    public void actualizarLote() {
        int idLote = view.seleccionarLote();
        Lote lote = dao.getLoteById(idLote);
        if (lote != null) {
            lote.setNombre(view.getNombreLote());
            lote.setIdPropietario(view.getIdPropietario());
            lote.setIdParcela(view.getIdParcela());
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
}
