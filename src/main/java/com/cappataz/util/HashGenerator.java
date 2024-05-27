package main.java.com.cappataz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase de utilidad para generar hashes de contraseñas.
 * Utiliza el algoritmo SHA-256 para generar el hash de una cadena de texto
 * dada,
 * típicamente utilizada para almacenar contraseñas de forma segura.
 */
public class HashGenerator {

    /**
     * Método principal que se utiliza para demostrar el hashing de una contraseña.
     * 
     * @param args Argumentos de línea de comando no utilizados en este método.
     */
    public static void main(String[] args) {
        String password = "1234";
        String hashedPassword = hashPassword(password);
        System.out.println("Hash SHA-256 para '1234': " + hashedPassword);
    }

    /**
     * Genera un hash SHA-256 para una contraseña dada.
     *
     * @param password La contraseña a ser hasheada.
     * @return Una cadena hexadecimal que representa el hash SHA-256 de la
     *         contraseña.
     * @throws RuntimeException Si el algoritmo SHA-256 no está disponible en el
     *                          entorno.
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al intentar hash la contraseña", e);
        }
    }
}
