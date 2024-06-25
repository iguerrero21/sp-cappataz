package main.java.com.cappataz.vista;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import main.java.com.cappataz.modelo.Propiedad;

public class PropiedadView extends JPanel {
    private JTable tablaPropiedades;
    private JButton btnRegistrarPropiedad;
    private JButton btnVisualizarPropiedad;
    private JButton btnModificarPropiedad;
    private JButton btnBorrarPropiedad;

    public PropiedadView() {
        setLayout(new BorderLayout());

        tablaPropiedades = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaPropiedades);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 4));

        btnRegistrarPropiedad = new JButton("Registrar Propiedad");
        btnVisualizarPropiedad = new JButton("Visualizar Propiedad");
        btnModificarPropiedad = new JButton("Modificar Propiedad");
        btnBorrarPropiedad = new JButton("Borrar Propiedad");

        panelBotones.add(btnRegistrarPropiedad);
        panelBotones.add(btnVisualizarPropiedad);
        panelBotones.add(btnModificarPropiedad);
        panelBotones.add(btnBorrarPropiedad);

        add(panelBotones, BorderLayout.SOUTH);
    }

    public JTable getTablaPropiedades() {
        return tablaPropiedades;
    }

    public JButton getBtnRegistrarPropiedad() {
        return btnRegistrarPropiedad;
    }

    public JButton getBtnVisualizarPropiedad() {
        return btnVisualizarPropiedad;
    }

    public JButton getBtnModificarPropiedad() {
        return btnModificarPropiedad;
    }

    public JButton getBtnBorrarPropiedad() {
        return btnBorrarPropiedad;
    }

    public void mostrarPropiedades(List<Propiedad> propiedades, List<String> nombresPropietarios) {
        String[] columnNames = { "ID", "Nombre", "Ubicación", "Superficie", "Tipo", "Fecha Registro", "Propietario" };
        Object[][] data = new Object[propiedades.size()][7];

        for (int i = 0; i < propiedades.size(); i++) {
            Propiedad propiedad = propiedades.get(i);
            data[i][0] = propiedad.getIdPropiedad(); // Asegúrate de que este dato es Integer
            data[i][1] = propiedad.getNombrePropiedad();
            data[i][2] = propiedad.getUbicacion();
            data[i][3] = propiedad.getSuperficie();
            data[i][4] = propiedad.getTipoPropiedad();
            data[i][5] = propiedad.getFechaRegistro();
            data[i][6] = nombresPropietarios.get(i);
        }

        tablaPropiedades.setModel(new javax.swing.table.DefaultTableModel(
                data,
                columnNames));
    }

    public int getIdPropiedad() {
        String input = JOptionPane.showInputDialog("Ingrese el ID de la propiedad:");
        return Integer.parseInt(input);
    }
}
