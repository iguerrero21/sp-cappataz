package main.java.com.cappataz.vista;

import java.util.List;
import java.util.Scanner;

import main.java.com.cappataz.modelo.Propiedad;
import main.java.com.cappataz.modelo.Propietario;
import main.java.com.cappataz.util.InputValidator;

public class PropiedadView {
    private Scanner scanner = new Scanner(System.in);

    public String getNombrePropiedad() {
        System.out.print("Ingrese el nombre de la propiedad: ");
        return scanner.nextLine();
    }

    public String getUbicacion() {
        System.out.print("Ingrese la ubicación de la propiedad: ");
        return scanner.nextLine();
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

    public void mostrarTodasLasPropiedades(List<Propiedad> propiedades, List<String> nombresPropietarios) {
        System.out.printf("%-5s %-20s %-15s %-10s %-15s %-15s %-25s%n",
                "ID", "Nombre", "Ubicación", "Superficie", "Tipo", "Fecha Registro", "Propietario");
        for (int i = 0; i < propiedades.size(); i++) {
            Propiedad propiedad = propiedades.get(i);
            String nombrePropietario = nombresPropietarios.get(i);
            System.out.printf("%-5d %-20s %-15s %-10.2f %-15s %-15s %-25s%n",
                    propiedad.getIdPropiedad(),
                    propiedad.getNombrePropiedad(),
                    propiedad.getUbicacion(),
                    propiedad.getSuperficie(),
                    propiedad.getTipoPropiedad(),
                    propiedad.getFechaRegistro().toString(),
                    nombrePropietario);
        }
    }

    public void mostrarDetallesPropiedad(Propiedad propiedad) {
        System.out.printf("%-5s %-20s %-20s %-10s %-15s %-20s %-25s%n",
                "ID", "Nombre", "Ubicación", "Superficie", "Tipo", "Fecha Registro", "Propietario");
        System.out.printf("%-5d %-20s %-20s %-10.2f %-15s %-20s %-25s%n",
                propiedad.getIdPropiedad(),
                propiedad.getNombrePropiedad(),
                propiedad.getUbicacion(),
                propiedad.getSuperficie(),
                propiedad.getTipoPropiedad(),
                propiedad.getFechaRegistro().toString(),
                propiedad.getIdPropietario());
    }

    public void mostrarDetallesPropiedadConPropietario(Propiedad propiedad, String nombrePropietario) {
        System.out.printf("%-5s %-20s %-20s %-10s %-15s %-20s %-25s%n",
                "ID", "Nombre", "Ubicación", "Superficie", "Tipo", "Fecha Registro", "Propietario");
        System.out.printf("%-5d %-20s %-20s %-10.2f %-15s %-20s %-25s%n",
                propiedad.getIdPropiedad(),
                propiedad.getNombrePropiedad(),
                propiedad.getUbicacion(),
                propiedad.getSuperficie(),
                propiedad.getTipoPropiedad(),
                propiedad.getFechaRegistro().toString(),
                nombrePropietario);
    }

    public int getIdPropiedad() {
        System.out.print("Ingrese el ID de la propiedad: ");
        return scanner.nextInt();
    }

    public int mostrarMenuPropiedades() {
        System.out.println("\n1. Siguiente página");
        System.out.println("2. Anterior página");
        System.out.println("3. Seleccionar propiedad");
        System.out.println("4. Modificar propiedad");
        System.out.println("5. Filtrar propiedades por propietario");
        System.out.println("6. Volver");
        System.out.println("7. Menú inicial");
        System.out.print("Seleccione una opción: ");
        return InputValidator.obtenerEntradaValida(scanner);
    }

    public int seleccionarPropietario(List<Propietario> propietarios) {
        System.out.println("\nLista de Propietarios:");
        for (int i = 0; i < propietarios.size(); i++) {
            System.out.printf("%d. %s %s\n", i + 1, propietarios.get(i).getNombre(), propietarios.get(i).getApellido());
        }
        System.out.print("Seleccione un propietario por número: ");
        return InputValidator.obtenerEntradaValida(scanner);
    }

    public void mostrarMenuGestionPropiedad() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenú de Gestión de Propiedad:");
            System.out.println("1. Ver parcelas");
            System.out.println("2. Crear parcela");
            System.out.println("3. Modificar parcela");
            System.out.println("4. Eliminar parcela");
            System.out.println("5. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            int choice = InputValidator.obtenerEntradaValida(scanner);

            switch (choice) {
                case 1:
                    // Lógica para ver parcelas
                    break;
                case 2:
                    // Lógica para crear parcela
                    break;
                case 3:
                    // Lógica para modificar parcela
                    break;
                case 4:
                    // Lógica para eliminar parcela
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    public void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
