package main.java.com.cappataz.vista;

import main.java.com.cappataz.modelo.Propiedad;

import java.util.List;
import java.util.Scanner;

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

    public void displayPropiedadDetails(Propiedad propiedad) {
        System.out.printf("%-15s %-20s %-20s %-10s %-15s %-20s %-15s%n",
                "ID Propiedad", "Nombre", "Ubicación", "Superficie", "Tipo", "Fecha Registro", "ID Propietario");
        System.out.printf("%-15d %-20s %-20s %-10.2f %-15s %-20s %-15d%n",
                propiedad.getIdPropiedad(),
                propiedad.getNombrePropiedad(),
                propiedad.getUbicacion(),
                propiedad.getSuperficie(),
                propiedad.getTipoPropiedad(),
                propiedad.getFechaRegistro().toString(),
                propiedad.getIdPropietario());
    }

    public void displayAllPropiedades(List<Propiedad> propiedades) {
        System.out.printf("%-15s %-20s %-20s %-10s %-15s %-20s %-15s%n",
                "ID Propiedad", "Nombre", "Ubicación", "Superficie", "Tipo", "Fecha Registro", "ID Propietario");
        for (Propiedad propiedad : propiedades) {
            System.out.printf("%-15d %-20s %-20s %-10.2f %-15s %-20s %-15d%n",
                    propiedad.getIdPropiedad(),
                    propiedad.getNombrePropiedad(),
                    propiedad.getUbicacion(),
                    propiedad.getSuperficie(),
                    propiedad.getTipoPropiedad(),
                    propiedad.getFechaRegistro().toString(),
                    propiedad.getIdPropietario());
        }
    }

    public int getIdPropiedad() {
        System.out.print("Ingrese el ID de la propiedad: ");
        return scanner.nextInt();
    }
}
