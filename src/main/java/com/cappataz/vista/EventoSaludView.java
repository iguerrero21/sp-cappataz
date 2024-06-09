package main.java.com.cappataz.vista;

import main.java.com.cappataz.modelo.EventoSalud;

import java.util.Scanner;
import java.sql.Date;

public class EventoSaludView {
    private Scanner scanner = new Scanner(System.in);

    public EventoSalud obtenerDatosEventoSalud() {
        EventoSalud evento = new EventoSalud();
        System.out.print("Ingrese ID del animal: ");
        evento.setIdAnimal(scanner.nextInt());
        System.out.print("Ingrese fecha (YYYY-MM-DD): ");
        evento.setFecha(Date.valueOf(scanner.next()));
        System.out.print("Ingrese enfermedad: ");
        evento.setEnfermedad(scanner.next());
        System.out.print("Ingrese tratamiento: ");
        evento.setTratamiento(scanner.next());
        System.out.print("Ingrese ID del operario: ");
        evento.setIdOperario(scanner.nextInt());
        return evento;
    }

    public void mostrarEventoSaludRegistrado(EventoSalud evento) {
        System.out.println("Evento de salud registrado con éxito.");
    }
}
