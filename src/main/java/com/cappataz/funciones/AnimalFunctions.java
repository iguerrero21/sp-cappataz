package main.java.com.cappataz.funciones;

import main.java.com.cappataz.controlador.AnimalController;
import main.java.com.cappataz.controlador.EventoSanitarioController;
import main.java.com.cappataz.vista.AnimalView;
import main.java.com.cappataz.vista.EventoSanitarioView;

public class AnimalFunctions {

    
    public static void registrarAnimal() {
        AnimalView animalView = new AnimalView();
        AnimalController animalController = new AnimalController(animalView);
        animalController.saveAnimal();
    }

    
    /** 
     * @param idPropietario
     */
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

