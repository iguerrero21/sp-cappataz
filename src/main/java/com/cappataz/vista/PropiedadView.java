package main.java.com.cappataz.vista;

import java.util.List;
import java.util.Scanner;

import main.java.com.cappataz.controlador.PropiedadController;
import main.java.com.cappataz.funciones.PropiedadFunctions;

public class PropiedadView {
    private Scanner scanner = new Scanner(System.in);

    public String getNombrePropiedad() {
        System.out.print("Ingrese el nombre de la propiedad: ");
        return scanner.next();
    }

    public String getUbicacion() {
        System.out.print("Ingrese la ubicación de la propiedad: ");
        return scanner.next();
    }

    public double getSuperficie() {
        System.out.print("Ingrese la superficie de la propiedad: ");
        return scanner.nextDouble();
    }

    public String getTipoPropiedad() {
        System.out.print("Ingrese el tipo de la propiedad: ");
        return scanner.next();
    }

    public int getIdPropietario() {
        System.out.print("Ingrese el ID del propietario: ");
        return scanner.nextInt();
    }

    public void mostrarTodasLasPropiedades(List<Object[]> propiedades) {
        System.out.printf("%-5s %-20s %-15s %-10s %-15s %-15s %-25s%n",
                "ID", "Nombre", "Ubicación", "Superficie", "Tipo", "Fecha Registro", "Propietario");
        for (Object[] propiedad : propiedades) {
            System.out.printf("%-5d %-20s %-15s %-10.2f %-15s %-15s %-25s%n",
                    propiedad[0],
                    propiedad[1],
                    propiedad[2],
                    propiedad[3],
                    propiedad[4],
                    propiedad[5].toString(),
                    propiedad[6]);
        }
    }

    public void mostrarDetallesPropiedades(Object[] propiedad) {
        System.out.printf("%-5s %-20s %-20s %-10s %-15s %-20s %-25s%n",
                "ID", "Nombre", "Ubicación", "Superficie", "Tipo", "Fecha Registro", "Propietario");
        System.out.printf("%-5d %-20s %-20s %-10.2f %-15s %-20s %-25s%n",
                propiedad[0],
                propiedad[1],
                propiedad[2],
                propiedad[3],
                propiedad[4],
                propiedad[5].toString(),
                propiedad[6]);
    }

    public int getIdPropiedad() {
        System.out.print("Ingrese el ID de la propiedad: ");
        return scanner.nextInt();
    }

    public void mostrarMenuPaginacion(PropiedadController propiedadController, int pageNumber, int pageSize) {
        boolean exit = false;

        while (!exit) {
            List<Object[]> propiedades = propiedadController.getPropiedadesPaginated(pageNumber, pageSize);
            if (propiedades.isEmpty()) {
                System.out.println("No hay más propiedades.");
                break;
            }
            mostrarTodasLasPropiedades(propiedades);

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
                    if (pageNumber > 0) pageNumber--;
                    break;
                case 3:
                    PropiedadFunctions.seleccionarPropiedad();
                    break;
                case 4:
                    PropiedadFunctions.modificarPropiedad();
                    break;
                case 5:
                    PropiedadFunctions.filtrarPropiedadesPorPropietario();
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
    }
}
