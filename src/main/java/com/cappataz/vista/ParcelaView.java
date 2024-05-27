package main.java.com.cappataz.vista;

import main.java.com.cappataz.modelo.Parcela;

import java.util.List;
import java.util.Scanner;

public class ParcelaView {
    private Scanner scanner = new Scanner(System.in);

    public int getIdPropiedad() {
        System.out.print("Ingrese el ID de la propiedad: ");
        return scanner.nextInt();
    }

    public String getNombreParcela() {
        System.out.print("Ingrese el nombre de la parcela: ");
        return scanner.next();
    }

    public String getUbicacion() {
        System.out.print("Ingrese la ubicación de la parcela: ");
        return scanner.next();
    }

    public double getSuperficie() {
        System.out.print("Ingrese la superficie de la parcela: ");
        return scanner.nextDouble();
    }

    public String getUso() {
        System.out.print("Ingrese el uso de la parcela: ");
        return scanner.next();
    }

    public void mostrarDetallesParcelas(Parcela parcela) {
        System.out.printf("%-5s %-20s %-20s %-10s %-15s %-15s%n",
                "ID", "Nombre", "Ubicación", "Superficie", "Uso", "ID Propiedad");
        System.out.printf("%-5d %-20s %-20s %-10.2f %-15s %-15d%n",
                parcela.getIdParcela(),
                parcela.getNombreParcela(),
                parcela.getUbicacion(),
                parcela.getSuperficie(),
                parcela.getUso(),
                parcela.getIdPropiedad());
    }

    public void mostrarTodasLasParcelas(List<Parcela> parcelas) {
        System.out.printf("%-5s %-20s %-20s %-10s %-15s %-15s%n",
                "ID", "Nombre", "Ubicación", "Superficie", "Uso", "ID Propiedad");
        for (Parcela parcela : parcelas) {
            System.out.printf("%-5d %-20s %-20s %-10.2f %-15s %-15d%n",
                    parcela.getIdParcela(),
                    parcela.getNombreParcela(),
                    parcela.getUbicacion(),
                    parcela.getSuperficie(),
                    parcela.getUso(),
                    parcela.getIdPropiedad());
        }
    }
}
