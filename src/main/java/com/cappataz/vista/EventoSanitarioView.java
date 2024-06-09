package main.java.com.cappataz.vista;

import main.java.com.cappataz.modelo.EventoSanitario;

import java.util.List;
import java.util.Scanner;

public class EventoSanitarioView {
    private Scanner scanner;

    public EventoSanitarioView() {
        this.scanner = new Scanner(System.in);
    }

    public EventoSanitario obtenerDatosEventoSanitario() {
        EventoSanitario evento = new EventoSanitario();
        System.out.print("Ingrese la fecha de inicio (yyyy-mm-dd): ");
        evento.setFechaInicio(java.sql.Date.valueOf(scanner.next()));
        System.out.print("Ingrese la fecha de fin (yyyy-mm-dd): ");
        evento.setFechaFin(java.sql.Date.valueOf(scanner.next()));
        System.out.print("Ingrese el tratamiento: ");
        evento.setTratamiento(scanner.next());
        System.out.print("Ingrese el resultado: ");
        evento.setResultado(scanner.next());
        System.out.print("Ingrese la categoría: ");
        evento.setIdCategoria(scanner.nextInt());
        System.out.print("Ingrese el ID del operario: ");
        evento.setIdOperario(scanner.nextInt());
        return evento;
    }

    public int getIdAnimal() {
        System.out.print("Ingrese el ID del animal: ");
        return scanner.nextInt();
    }

    public int getIdLote() {
        System.out.print("Ingrese el ID del lote: ");
        return scanner.nextInt();
    }

    public int getIdSanidad() {
        System.out.print("Ingrese el ID del evento sanitario: ");
        return scanner.nextInt();
    }

    public void mostrarEventoSanitario(EventoSanitario evento) {
        System.out.printf(
                "Evento Sanitario - ID: %d, ID Animal: %d, ID Lote: %d, Fecha Inicio: %s, Fecha Fin: %s, Tratamiento: %s, Resultado: %s, Categoría: %d, ID Operario: %d%n",
                evento.getIdSanidad(), evento.getIdAnimal(), evento.getIdLote(), evento.getFechaInicio(),
                evento.getFechaFin(), evento.getTratamiento(), evento.getResultado(), evento.getIdCategoria(),
                evento.getIdOperario());
    }

    public void mostrarDetallesDeTodosLosEventos(List<EventoSanitario> eventos) {
        for (EventoSanitario evento : eventos) {
            mostrarEventoSanitario(evento);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
