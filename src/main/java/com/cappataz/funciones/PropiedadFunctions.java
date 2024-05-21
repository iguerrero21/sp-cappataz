package main.java.com.cappataz.funciones;

import main.java.com.cappataz.controlador.PropiedadController;
import main.java.com.cappataz.controlador.ParcelaController;
import main.java.com.cappataz.modelo.Propiedad;
import main.java.com.cappataz.modelo.Parcela;
import main.java.com.cappataz.vista.PropiedadView;
import main.java.com.cappataz.vista.ParcelaView;

public class PropiedadFunctions {
    public static void registrarPropiedad() {
        PropiedadView propiedadView = new PropiedadView();
        Propiedad propiedad = new Propiedad(0, propiedadView.getNombrePropiedad(), propiedadView.getUbicacion(),
                propiedadView.getSuperficie(), propiedadView.getTipoPropiedad(), null,
                propiedadView.getIdPropietario());
        PropiedadController propiedadController = new PropiedadController(propiedad, propiedadView);
        propiedadController.savePropiedad();
    }

    public static void crearParcelas() {
        ParcelaView parcelaView = new ParcelaView();
        Parcela parcela = new Parcela(0, parcelaView.getNombreParcela(), parcelaView.getUbicacion(),
                parcelaView.getSuperficie(), parcelaView.getUso(), parcelaView.getIdPropiedad());
        ParcelaController parcelaController = new ParcelaController(parcela, parcelaView);
        parcelaController.saveParcela();
    }

    public static void mostrarPropiedades() {
        PropiedadView propiedadView = new PropiedadView();
        PropiedadController propiedadController = new PropiedadController(null, propiedadView);
        propiedadController.displayAllPropiedades();
    }

    public static void verParcelasDePropiedad() {
        PropiedadView propiedadView = new PropiedadView();
        int idPropiedad = propiedadView.getIdPropiedad();
        ParcelaController parcelaController = new ParcelaController(null, new ParcelaView());
        parcelaController.displayParcelasByPropiedad(idPropiedad);
    }
}
