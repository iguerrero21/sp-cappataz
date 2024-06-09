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

    public Lote obtenerDatosLote() {
        Lote lote = new Lote();
        System.out.print("Ingrese el nombre del lote: ");
        lote.setNombre(scanner.next());
        System.out.print("Ingrese el ID del propietario: ");
        lote.setIdPropietario(scanner.nextInt());
        System.out.print("Ingrese el ID de la parcela: ");
        lote.setIdParcela(scanner.nextInt());
        return lote;
    }

    public int getIdLote() {
        System.out.print("Ingrese el ID del lote: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarRegistrarEventoSanitarioLote(Lote lote) {
        System.out.printf("Registrar evento sanitario para el lote: %s (ID: %d)%n", lote.getNombre(), lote.getId());
        // Aquí puedes mostrar más información sobre el lote si lo deseas
    }

    public void mostrarEventoSanitarioLote(Lote lote) {
        System.out.printf("Eventos sanitarios para el lote: %s (ID: %d)%n", lote.getNombre(), lote.getId());
        // Aquí puedes mostrar más información sobre el lote si lo deseas
    }
}
