package main.java.com.cappataz.funciones;

import main.java.com.cappataz.controlador.PropiedadController;
import main.java.com.cappataz.controlador.ParcelaController;
import main.java.com.cappataz.modelo.Propiedad;
import main.java.com.cappataz.modelo.Propietario;
import main.java.com.cappataz.modelo.Parcela;
import main.java.com.cappataz.vista.PropiedadView;
import main.java.com.cappataz.vista.ParcelaView;

import java.util.List;
import java.util.Scanner;

public class PropiedadFunctions {

    private static final int PAGE_SIZE = 10;

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

    public static void mostrarPropiedadesPaginado() {
        PropiedadView propiedadView = new PropiedadView();
        PropiedadController propiedadController = new PropiedadController(propiedadView);

        int pageNumber = 0;
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            List<Object[]> propiedades = propiedadController.getPropiedadesPaginated(pageNumber, PAGE_SIZE);
            if (propiedades.isEmpty()) {
                System.out.println("No hay más propiedades.");
                break;
            }
            propiedadView.mostrarTodasLasPropiedades(propiedades);

            System.out.println("\n1. Siguiente página");
            System.out.println("2. Anterior página");
            System.out.println("3. Seleccionar propiedad");
            System.out.println("4. Modificar propiedad");
            System.out.println("5. Filtrar propiedades por propietario");
            System.out.println("6. Volver");
            System.out.println("7. Menú inicial");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    pageNumber++;
                    break;
                case 2:
                    if (pageNumber > 0)
                        pageNumber--;
                    break;
                case 3:
                    seleccionarPropiedad();
                    break;
                case 4:
                    modificarPropiedad();
                    break;
                case 5:
                    filtrarPropiedadesPorPropietario();
                    break;
                case 6:
                    exit = true;
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        scanner.close();
    }

    public static void seleccionarPropiedad() {
        PropiedadView propiedadView = new PropiedadView();
        int idPropiedad = propiedadView.getIdPropiedad();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        propiedadController.displayPropiedadById(idPropiedad);
        ParcelaController parcelaController = new ParcelaController(null, new ParcelaView());
        parcelaController.displayParcelasByPropiedad(idPropiedad);
    }

    public static void modificarPropiedad() {
        PropiedadView propiedadView = new PropiedadView();
        int idPropiedad = propiedadView.getIdPropiedad();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        propiedadController.modifyPropiedad(idPropiedad);
    }

    public static void filtrarPropiedadesPorPropietario() {
        Propietario propietario = UsuarioFunctions.seleccionarPropietario();
        if (propietario == null) return;

        PropiedadView propiedadView = new PropiedadView();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        propiedadController.displayPropiedadesByPropietario(propietario.getIdUsuario());
    }
}

// package main.java.com.cappataz.funciones;

// import main.java.com.cappataz.controlador.PropiedadController;
// import main.java.com.cappataz.controlador.ParcelaController;
// import main.java.com.cappataz.modelo.Propiedad;
// import main.java.com.cappataz.modelo.Parcela;
// import main.java.com.cappataz.vista.PropiedadView;
// import main.java.com.cappataz.vista.ParcelaView;

// public class PropiedadFunctions {
    
//     public static void registrarPropiedad() {
//         PropiedadView propiedadView = new PropiedadView();
//         Propiedad propiedad = new Propiedad(0, propiedadView.getNombrePropiedad(), propiedadView.getUbicacion(),
//                 propiedadView.getSuperficie(), propiedadView.getTipoPropiedad(), null,
//                 propiedadView.getIdPropietario());
//         PropiedadController propiedadController = new PropiedadController(propiedadView);
//         propiedadController.savePropiedad(propiedad);
//     }

//     public static void crearParcelas() {
//         ParcelaView parcelaView = new ParcelaView();
//         Parcela parcela = new Parcela(0, parcelaView.getNombreParcela(), parcelaView.getUbicacion(),
//                 parcelaView.getSuperficie(), parcelaView.getUso(), parcelaView.getIdPropiedad());
//         ParcelaController parcelaController = new ParcelaController(parcela, parcelaView);
//         parcelaController.saveParcela();
//     }

//     public static void mostrarPropiedades() {
//         PropiedadView propiedadView = new PropiedadView();
//         PropiedadController propiedadController = new PropiedadController(propiedadView);
//         propiedadController.displayAllPropiedades();
//     }

//     public static void verParcelasDePropiedad() {
//         PropiedadView propiedadView = new PropiedadView();
//         int idPropiedad = propiedadView.getIdPropiedad();
//         ParcelaController parcelaController = new ParcelaController(null, new ParcelaView());
//         parcelaController.displayParcelasByPropiedad(idPropiedad);
//     }
// }
