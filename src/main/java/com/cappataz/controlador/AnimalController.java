package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.AnimalDAO;
import main.java.com.cappataz.modelo.Animal;
import main.java.com.cappataz.vista.AnimalView;

import java.util.List;

public class AnimalController {
    private Animal model;
    private AnimalView view;
    private AnimalDAO dao;

    public AnimalController(Animal model, AnimalView view) {
        this.model = model;
        this.view = view;
        this.dao = new AnimalDAO();
    }

    public void saveAnimal() {
        model.setId(view.getId());
        model.setTagId(view.getTagId());
        model.setTagRFID(view.getTagRFID());
        model.setEspecie(view.getEspecie());
        model.setRaza(view.getRaza());
        model.setFechaNac(view.getFechaNac());
        model.setSexo(view.getSexo());
        model.setCastrado(view.getCastrado());
        model.setIdCategoria(view.getIdCategoria());
        model.setIdLote(view.getIdLote());
        model.setIdPropietario(view.getIdPropietario());
        dao.saveAnimal(model);
        view.mostrarDetallesAnimal(model);
    }

    public void displayAllAnimals() {
        List<Animal> animals = dao.getAllAnimals();
        view.mostrarDetallesdeTodoslosAnimales(animals);
    }

    public void mostrarAnimalesPorPropietario(int idPropietario) {
        List<Animal> animals = dao.getAnimalesPorPropietario(idPropietario);
        view.mostrarDetallesdeTodoslosAnimales(animals);
    }
}
