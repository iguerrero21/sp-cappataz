package main.java.com.cappataz.vista;

import java.util.Scanner;

import main.java.com.cappataz.modelo.Usuario;

public class UsuarioView {
    private Scanner scanner = new Scanner(System.in);

    public int getIdUsuario() {
        System.out.print("Ingrese ID del usuario: ");
        return scanner.nextInt();
    }

    public String getNombre() {
        System.out.print("Ingrese nombre del usuario: ");
        return scanner.next();
    }

    public String getApellido() {
        System.out.print("Ingrese apellido del usuario: ");
        return scanner.next();
    }

    public String getEmail() {
        System.out.print("Ingrese email del usuario: ");
        return scanner.next();
    }

    public int getIdRol() {
        System.out.print("Ingrese rol del usuario: ");
        return scanner.nextInt();
    }

    public void displayUsuarioDetails(Usuario usuario) {
        System.out.println(
                "Usuario guardado: " + usuario.getNombre() + " " + usuario.getApellido() + " (" + usuario.getEmail() + "), Rol: " + usuario.getIdRol());
    }

    public String getEmailForLogin() {
        System.out.print("Ingrese su email: ");
        return scanner.next();
    }

    public String getPasswordForLogin() {
        System.out.print("Ingrese su contraseña: ");
        return scanner.next();
    }

    public void displayLoginSuccess(String nombre) {
        System.out.println("Bienvenido, " + nombre + "!");
    }

    public void displayLoginFailure() {
        System.out.println("Email o contraseña incorrectos. Inténtelo de nuevo.");
    }
}
