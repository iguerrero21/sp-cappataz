package main.java.com.cappataz.vista;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import main.java.com.cappataz.modelo.IUsuario;

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
        int rol = -1;
        while (rol < 1 || rol > 3) {
            try {
                System.out.print("Ingrese el número correspondiente al rol (1-Administrador, 2-Propietario, 3-Operario): ");
                rol = scanner.nextInt();
                if (rol < 1 || rol > 3) {
                    System.out.println("Rol no válido. Por favor, ingrese un número entre 1 y 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar la entrada inválida
            }
        }
        return rol;
    }

    public void mostrarDetallesUsuario(IUsuario usuario) {
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

    public void mostrarLogueoExitoso(String nombre) {
        System.out.println("Bienvenido, " + nombre + "!");
    }

    public void mostrarErrorLogueo() {
        System.out.println("Email o contraseña incorrectos. Inténtelo de nuevo.");
    }

    public void mostrarTodosLosUsuarios(List<IUsuario> usuarios) {
        System.out.printf("%-5s %-15s %-15s %-30s %-15s%n", "ID", "Nombre", "Apellido", "Email", "Rol");
        for (IUsuario usuario : usuarios) {
            System.out.printf("%-5d %-15s %-15s %-30s %-15s%n", usuario.getIdUsuario(), usuario.getNombre(),
                    usuario.getApellido(), usuario.getEmail(), usuario.getRol());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
