package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.AnimalDAO;
import main.java.com.cappataz.modelo.Animal;
import main.java.com.cappataz.vista.AnimalView;

import java.util.List;

public class AnimalController {
    private AnimalView view;
    private AnimalDAO dao;

    public AnimalController(AnimalView view) {
        this.view = view;
        this.dao = new AnimalDAO();
    }

    public void saveAnimal() {
        Animal animal = view.cargarAnimal();
        dao.saveAnimal(animal);
        view.mostrarDetallesAnimal(animal);
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
