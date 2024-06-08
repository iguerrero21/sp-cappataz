package main.java.com.cappataz.util;

import java.util.Scanner;

public class InputValidator {

    public static int obtenerEntradaValida(Scanner scanner) {
        int entrada = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                entrada = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
                            
        }
        return entrada;
    }
}
