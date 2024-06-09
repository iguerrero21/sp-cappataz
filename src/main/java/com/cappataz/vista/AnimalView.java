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

    public Animal cargarAnimal() {
        Animal animal = new Animal();
        System.out.print("Ingrese ID del animal: ");
        animal.setId(scanner.nextInt());
        System.out.print("Ingrese Tag ID del animal: ");
        animal.setTagId(scanner.next());
        System.out.print("Ingrese Tag RFID del animal: ");
        animal.setTagRFID(scanner.next());
        System.out.print("Ingrese especie del animal: ");
        animal.setEspecie(scanner.next());
        System.out.print("Ingrese raza del animal: ");
        animal.setRaza(scanner.next());
        System.out.print("Ingrese fecha de nacimiento del animal (YYYY-MM-DD): ");
        animal.setFechaNac(Date.valueOf(scanner.next()));
        System.out.print("Ingrese sexo del animal (M/F): ");
        animal.setSexo(scanner.next().charAt(0));
        System.out.print("Ingrese si el animal está castrado (true/false): ");
        animal.setCastrado(scanner.nextBoolean());
        System.out.print("Ingrese ID de categoría del animal: ");
        animal.setIdCategoria(scanner.nextInt());
        System.out.print("Ingrese ID de lote del animal: ");
        animal.setIdLote(scanner.nextInt());
        System.out.print("Ingrese ID del propietario del animal: ");
        animal.setIdPropietario(scanner.nextInt());
        return animal;
    }

    public void mostrarDetallesAnimal(Animal animal) {
        System.out.println("Detalles del Animal:");
        System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                "ID", "Caravana", "RFID", "Especie", "Raza", "Nacido", "Categoría", "Lote", "Propietario");
        System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                animal.getId(), animal.getTagId(), animal.getTagRFID(), animal.getEspecie(), animal.getRaza(),
                animal.getFechaNac(), animal.getIdCategoria(), animal.getIdLote(), animal.getIdPropietario());
    }

    public void mostrarDetallesdeTodoslosAnimales(List<Animal> animals) {
        System.out.println("Detalles de Todos los Animales:");
        System.out.printf("%-5s %-10s %-10s %-10s %-15s %-10s %-10s %-10s %-15s%n",
                "ID", "Caravana", "RFID", "Especie", "Raza", "Nacido", "Categoría", "Lote", "Propietario");
        for (Animal animal : animals) {
            System.out.printf("%-5s %-10s %-10s %-10s %-15s %-10s %-10s %-10s %-15s%n",
                    animal.getId(), animal.getTagId(), animal.getTagRFID(), animal.getEspecie(), animal.getRaza(),
                    animal.getFechaNac(), animal.getIdCategoria(), animal.getIdLote(), animal.getIdPropietario());
        }
    }
}

