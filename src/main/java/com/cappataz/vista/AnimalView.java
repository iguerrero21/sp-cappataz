package main.java.com.cappataz.vista;

import java.sql.Date;
import java.util.List;
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

    public void mostrarDetallesAnimal(Animal animal) {
        System.out.println("Animal Details:");
        System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s %-5s %-10s %-10s %-5s %-10s%n", 
        "ID", "Caravana", "RFID", "Especie", "Raza", "Nacido", "Sexo", "Castrado", "Categoría", "Lote", "Propietario" );
        System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s %-5s %-10s %-10s %-5s %-10s%n",
                animal.getId(), animal.getTagId(), animal.getTagRFID(), animal.getEspecie(), animal.getRaza(),
                animal.getFechaNac(), animal.getSexo(), animal.getCastrado(), animal.getIdCategoria(), 
                animal.getIdLote(), animal.getIdPropietario());
    }

    public void mostrarDetallesdeTodoslosAnimales(List<Animal> animals) {
        System.out.println("Detalles de los Animales:");
        System.out.printf("%-5s %-10s %-10s %-10s %-15s %-10s %-15s %-10s%n",
                "ID", "Caravana", "RFID", "Especie", "Raza", "Nacido", "Categoría", "Propietario");
        for (Animal animal : animals) {
            System.out.printf("%-5s %-10s %-10s %-10s %-15s %-10s %-15s %-10s%n",
                    animal.getId(), animal.getTagId(), animal.getTagRFID(), animal.getEspecie(),
                    animal.getRaza(), animal.getFechaNac(), animal.getNombreCategoria(), animal.getNombrePropietario());
        }
    }
}
