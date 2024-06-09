package main.java.com.cappataz.funciones;

import main.java.com.cappataz.controlador.AnimalController;
import main.java.com.cappataz.controlador.EventoSanitarioController;
import main.java.com.cappataz.dao.AnimalDAO;
import main.java.com.cappataz.modelo.Animal;
import main.java.com.cappataz.vista.AnimalView;
import main.java.com.cappataz.vista.EventoSanitarioView;
import main.java.com.cappataz.util.ConsoleUtils;

import java.util.List;
import java.util.Scanner;

public class AnimalFunctions {

    public static void registrarAnimal() {
        AnimalView animalView = new AnimalView();
        AnimalController animalController = new AnimalController(animalView);
        animalController.saveAnimal();
    }

    public static void mostrarAnimalesPorPropietario(int idPropietario) {
        AnimalView animalView = new AnimalView();
        AnimalController animalController = new AnimalController(animalView);
        animalController.mostrarAnimalesPorPropietario(idPropietario);
    }

    public static void registrarEventoSanitarioAnimal() {
        EventoSanitarioView eventoSanitarioView = new EventoSanitarioView();
        EventoSanitarioController eventoSanitarioController = new EventoSanitarioController(eventoSanitarioView);
        eventoSanitarioController.registrarEventoSanitarioAnimal();
    }

}

