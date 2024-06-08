package main.java.com.cappataz.vista;

import main.java.com.cappataz.modelo.Lote;

import java.util.List;
import java.util.Scanner;

public class LoteView {
    private Scanner scanner;

    public LoteView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarLotes(List<Lote> lotes) {
        System.out.println("Lotes Disponibles:");
        System.out.printf("%-10s %-10s %-10s %-10s %-20s %-20s %-20s%n", "ID Lote", "Nombre", "Cantidad",
                "Categoría", "Propietario", "Propiedad", "Parcela");
        for (Lote lote : lotes) {
            System.out.printf("%-10d %-10s %-10d %-10s %-20s %-20s %-20s%n",
                    lote.getId(), lote.getNombre(), lote.getCantidadAnimales(), lote.getCategoria(),
                    lote.getNombrePropietario(), lote.getNombrePropiedad(), lote.getNombreParcela());
        }
    }

    public int seleccionarLote() {
        System.out.print("Ingrese el ID del lote que desea ver: ");
        return scanner.nextInt();
    }

    public void mostrarLote(Lote lote) {
        System.out.println("Detalles del Lote:");
        System.out.printf("%-20s: %d%n", "ID Lote", lote.getId());
        System.out.printf("%-20s: %s%n", "Nombre", lote.getNombre());
        System.out.printf("%-20s: %d%n", "Cantidad de Animales", lote.getCantidadAnimales());
        System.out.printf("%-20s: %s%n", "Categoría", lote.getCategoria());
        System.out.printf("%-20s: %s%n", "Propietario", lote.getNombrePropietario());
        System.out.printf("%-20s: %s%n", "Propiedad", lote.getNombrePropiedad());
        System.out.printf("%-20s: %s%n", "Parcela", lote.getNombreParcela());
        System.out.printf("%-20s: %s%n", "Fecha de Creación", lote.getFechaCreacion());
    }

    public String getNombreLote() {
        System.out.print("Ingrese el nombre del lote: ");
        return scanner.next();
    }

    public int getIdPropietario() {
        System.out.print("Ingrese el ID del propietario: ");
        return scanner.nextInt();
    }

    public int getIdParcela() {
        System.out.print("Ingrese el ID de la parcela: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
