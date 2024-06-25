package main.java.com.cappataz.gui;

import main.java.com.cappataz.controlador.ParcelaController;
import main.java.com.cappataz.modelo.Parcela;
import main.java.com.cappataz.vista.ParcelaView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelGestionParcelas extends JPanel {
    private JTable tablaParcelas;
    private ParcelaController parcelaController;
    private JButton btnVolver;

    public PanelGestionParcelas(int idPropiedad) {
        setLayout(new BorderLayout());

        // Crear el panel para la tabla de parcelas
        parcelaController = new ParcelaController(new ParcelaView());
        List<Parcela> parcelas = parcelaController.getParcelasByPropiedad(idPropiedad);

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

        tablaParcelas = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tablaParcelas);

        // Crear el panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 1));
        btnVolver = new JButton("Volver");

        btnVolver.addActionListener(e -> {
            // Lógica para volver al panel de propiedades
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.getContentPane().removeAll();
            topFrame.getContentPane().add(new PanelGestionPropiedades());
            topFrame.revalidate();
            topFrame.repaint();
        });

        panelBotones.add(btnVolver);

        // Añadir los paneles al layout principal
        add(panelBotones, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
    }
}
