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
        Propiedad propiedad = new Propiedad(
                0,
                propiedadView.getNombrePropiedad(),
                propiedadView.getUbicacion(),
                propiedadView.getSuperficie(),
                propiedadView.getTipoPropiedad(),
                null,
                propiedadView.getIdPropietario());
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        propiedadController.savePropiedad(propiedad);
    }

    public static void crearParcelas() {
        ParcelaView parcelaView = new ParcelaView();
        Parcela parcela = new Parcela(
                0,
                parcelaView.getNombreParcela(),
                parcelaView.getUbicacion(),
                parcelaView.getSuperficie(),
                parcelaView.getUso(),
                parcelaView.getIdPropiedad());
        ParcelaController parcelaController = new ParcelaController(parcela, parcelaView);
        parcelaController.saveParcela();
    }

    public static void modificarPropiedad() {
        PropiedadView propiedadView = new PropiedadView();
        int idPropiedad = propiedadView.getIdPropiedad();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        propiedadController.modifyPropiedad(idPropiedad);
    }

    public static void seleccionarPropiedad() {
        PropiedadView propiedadView = new PropiedadView();
        int idPropiedad = propiedadView.getIdPropiedad();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        propiedadController.displayPropiedadById(idPropiedad);
        ParcelaController parcelaController = new ParcelaController(null, new ParcelaView());
        parcelaController.displayParcelasByPropiedad(idPropiedad);
    }

    public static void mostrarPropiedadesPaginado() {
        PropiedadView propiedadView = new PropiedadView();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        propiedadController.gestionarPropiedades(); // Llama al método para gestionar propiedades
    }

    public static void filtrarPropiedadesPorPropietario() {
        PropiedadView propiedadView = new PropiedadView();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        propiedadController.filtrarPropiedadesPorPropietario();
    }
}