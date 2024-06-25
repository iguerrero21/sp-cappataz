package main.java.com.cappataz.gui;

import main.java.com.cappataz.controlador.PropiedadController;
import main.java.com.cappataz.modelo.Propiedad;
import main.java.com.cappataz.vista.PropiedadView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelGestionPropiedades extends JPanel {
    private JTable tablaPropiedades;
    private PropiedadController propiedadController;
    private JButton btnVolver;

    public PanelGestionPropiedades() {
        setLayout(new BorderLayout());

        // Crear el panel para la tabla de propiedades
        propiedadController = new PropiedadController(new PropiedadView());
        List<Propiedad> propiedades = propiedadController.getAllPropiedades();

        String[] columnNames = { "ID", "Nombre", "Ubicación", "Superficie", "Tipo", "Fecha Registro", "Propietario" };
        Object[][] data = new Object[propiedades.size()][7];

        for (int i = 0; i < propiedades.size(); i++) {
            Propiedad propiedad = propiedades.get(i);
            data[i][0] = propiedad.getIdPropiedad();
            data[i][1] = propiedad.getNombrePropiedad();
            data[i][2] = propiedad.getUbicacion();
            data[i][3] = propiedad.getSuperficie();
            data[i][4] = propiedad.getTipoPropiedad();
            data[i][5] = propiedad.getFechaRegistro().toString();
            data[i][6] = propiedadController.getNombrePropietario(propiedad.getIdPropietario()); // Obtén el nombre del
                                                                                                 // propietario
        }

        tablaPropiedades = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tablaPropiedades);

        // Crear el panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 1));
        btnVolver = new JButton("Volver");

        btnVolver.addActionListener(e -> {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.getContentPane().removeAll();
            topFrame.revalidate();
            topFrame.repaint();
        });

        panelBotones.add(btnVolver);

        // Añadir los paneles al layout principal
        add(panelBotones, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
    }
}
