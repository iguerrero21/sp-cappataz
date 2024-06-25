package main.java.com.cappataz.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionarUsuarios extends JFrame {
    private JTable tableUsuarios;
    private DefaultTableModel tableModel;
    private JButton btnAgregar, btnModificar, btnEliminar, btnVolver;
    private JPanel panelBotones;

    public GestionarUsuarios() {
        setTitle("Gestionar Usuarios");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear modelo de tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellido");
        tableModel.addColumn("Email");
        tableModel.addColumn("Rol");

        // Crear tabla
        tableUsuarios = new JTable(tableModel);
        add(new JScrollPane(tableUsuarios), BorderLayout.CENTER);

        // Crear panel de botones
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 4));

        btnAgregar = new JButton("Agregar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnVolver = new JButton("Volver");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.SOUTH);

        // Agregar listeners a los botones
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para agregar usuario
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para modificar usuario
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para eliminar usuario
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para volver al menú principal
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionarUsuarios().setVisible(true);
            }
        });
    }
}
