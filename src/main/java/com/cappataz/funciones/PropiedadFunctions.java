package main.java.com.cappataz.funciones;

import main.java.com.cappataz.controlador.ParcelaController;
import main.java.com.cappataz.controlador.PropiedadController;
import main.java.com.cappataz.modelo.Propiedad;
import main.java.com.cappataz.modelo.Parcela;
import main.java.com.cappataz.vista.ParcelaView;
import main.java.com.cappataz.vista.PropiedadView;

public class PropiedadFunctions {

    public static void registrarPropiedad() {
        PropiedadView propiedadView = new PropiedadView();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        propiedadController.registrarPropiedad(); // Muestra el diálogo para ingresar datos de la nueva propiedad
    }

    public static void crearParcelas() {
        ParcelaView parcelaView = new ParcelaView();
        ParcelaController parcelaController = new ParcelaController(parcelaView);
        parcelaController.registrarParcela(); // Muestra el diálogo para ingresar datos de la nueva parcela
    }

    public static void modificarPropiedad() {
        PropiedadView propiedadView = new PropiedadView();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        int idPropiedad = propiedadView.getIdPropiedad();
        propiedadController.modifyPropiedad(idPropiedad);
    }

    public static void seleccionarPropiedad() {
        PropiedadView propiedadView = new PropiedadView();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        int idPropiedad = propiedadView.getIdPropiedad();
        propiedadController.displayPropiedadById(idPropiedad);
        ParcelaController parcelaController = new ParcelaController(new ParcelaView());
        parcelaController.displayParcelasByPropiedad(idPropiedad);
    }

    public static void mostrarPropiedadesPaginado() {
        PropiedadView propiedadView = new PropiedadView();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        propiedadController.gestionarPropiedades();
    }

    public static void filtrarPropiedadesPorPropietario() {
        PropiedadView propiedadView = new PropiedadView();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        propiedadController.filtrarPropiedadesPorPropietario();
    }
}
