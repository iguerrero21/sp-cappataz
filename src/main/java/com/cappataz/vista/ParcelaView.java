package main.java.com.cappataz.vista;

import main.java.com.cappataz.modelo.Parcela;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class ParcelaView {
    private Scanner scanner = new Scanner(System.in);

    public Parcela obtenerDatosParcela() {
        System.out.print("Ingrese el nombre de la parcela: ");
        String nombreParcela = scanner.nextLine();

        System.out.print("Ingrese la ubicación de la parcela: ");
        String ubicacion = scanner.nextLine();

        System.out.print("Ingrese la superficie de la parcela: ");
        double superficie = scanner.nextDouble();

        System.out.print("Ingrese el uso de la parcela: ");
        String uso = scanner.next();

        System.out.print("Ingrese el ID de la propiedad: ");
        int idPropiedad = scanner.nextInt();

        return new Parcela(0, nombreParcela, ubicacion, superficie, uso, idPropiedad);
    }

    public void mostrarParcelas(List<Parcela> parcelas) {
        String[] columnNames = { "ID", "Nombre", "Ubicación", "Superficie", "Uso" };
        Object[][] data = new Object[parcelas.size()][5];

        for (int i = 0; i < parcelas.size(); i++) {
            Parcela parcela = parcelas.get(i);
            data[i][0] = parcela.getIdParcela();
            data[i][1] = parcela.getNombreParcela();
            data[i][2] = parcela.getUbicacion();
            data[i][3] = parcela.getSuperficie();
            data[i][4] = parcela.getUso();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("Parcelas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
