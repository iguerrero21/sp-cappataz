package main.java.com.cappataz.vista;
import java.util.Scanner;

public class UsuarioView {
    private Scanner scanner = new Scanner(System.in);

    public int getId() {
        System.out.print("Ingrese ID del usuario: ");
        return scanner.nextInt();
    }

    public String getNombre() {
        System.out.print("Ingrese nombre del usuario: ");
        return scanner.next();
    }

    public String getEmail() {
        System.out.print("Ingrese email del usuario: ");
        return scanner.next();
    }

    public String getRol() {
        System.out.print("Ingrese rol del usuario: ");
        return scanner.next();
    }

    public void displayUsuarioDetails(String nombre, String email, String rol) {
        System.out.println("Usuario guardado: " + nombre + " (" + email + "), Rol: " + rol);
    }
}