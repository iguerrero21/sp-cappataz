package main.java.com.cappataz.functions;

import main.java.com.cappataz.controlador.AnimalController;
import main.java.com.cappataz.modelo.Animal;
import main.java.com.cappataz.vista.AnimalView;

public class AnimalFunctions {
    public static void registrarAnimal() {
        Animal animalModel = new Animal();
        AnimalView animalView = new AnimalView();
        AnimalController animalController = new AnimalController(animalModel, animalView);
        animalController.saveAnimal();
    }

    public static void mostrarAnimales() {
        AnimalView animalView = new AnimalView();
        AnimalController animalController = new AnimalController(new Animal(), animalView);
        animalController.displayAllAnimals();
    }
}
