package main.java.com.cappataz.vista;

import java.sql.Date;
import java.util.Scanner;

import main.java.com.cappataz.modelo.Animal;

public class AnimalView {
    private Scanner scanner;

    public AnimalView() {
        this.scanner = new Scanner(System.in);
    }

    public int getId() {
        System.out.print("Ingrese ID del animal: ");
        return scanner.nextInt();
    }

    public String getTagId() {
        System.out.print("Ingrese Tag ID del animal: ");
        return scanner.next();
    }

    public String getTagRFID() {
        System.out.print("Ingrese Tag RFID del animal: ");
        return scanner.next();
    }

    public String getEspecie() {
        System.out.print("Ingrese especie del animal: ");
        return scanner.next();
    }

    public String getRaza() {
        System.out.print("Ingrese raza del animal: ");
        return scanner.next();
    }

    public Date getFechaNac() {
        System.out.print("Ingrese fecha de nacimiento del animal (YYYY-MM-DD): ");
        return Date.valueOf(scanner.next());
    }

    public Character getSexo() {
        System.out.print("Ingrese sexo del animal (M/F): ");
        return scanner.next().charAt(0);
    }

    public Boolean getCastrado() {
        System.out.print("Ingrese si el animal está castrado (true/false): ");
        return scanner.nextBoolean();
    }

    public int getIdCategoria() {
        System.out.print("Ingrese ID de categoría del animal: ");
        return scanner.nextInt();
    }

    public int getIdLote() {
        System.out.print("Ingrese ID de lote del animal: ");
        return scanner.nextInt();
    }

    public int getIdPropietario() {
        System.out.print("Ingrese ID del propietario del animal: ");
        return scanner.nextInt();
    }

    public void displayAnimalDetails(Animal animal) {
        System.out.println("Animal Details:");
        System.out.println("ID: " + animal.getId());
        System.out.println("Caravana: " + animal.getTagId());
        System.out.println("RFID: " + animal.getTagRFID());
        System.out.println("Especie: " + animal.getEspecie());
        System.out.println("Raza: " + animal.getRaza());
        System.out.println("Fecha de Nacimiento: " + animal.getFechaNac());
        System.out.println("Sexo: " + animal.getSexo());
        System.out.println("Castrado: " + animal.getCastrado());
        System.out.println("Categoría: " + animal.getIdCategoria());
        System.out.println("Lote N°: " + animal.getIdLote());
        System.out.println("Propietario: " + animal.getIdPropietario());
    }

}
