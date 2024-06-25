package main.java.com.cappataz.gui;

import main.java.com.cappataz.controlador.PropiedadController;
import main.java.com.cappataz.modelo.IUsuario;
import main.java.com.cappataz.vista.PropiedadView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private IUsuario usuario;
    private JPanel panelNavegacion;
    private JPanel panelCentral;
    private CardLayout cardLayout;
    private JButton btnGestionarUsuarios;
    private JButton btnGestionarPropiedades;
    private JButton btnGestionarAnimales;
    private JButton btnSalir;

    public MainFrame(IUsuario usuario) {
        this.usuario = usuario;
        setTitle("Sistema de Gestión Ganadera");
        setSize(1024, 576);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        panelNavegacion = new JPanel();
        panelNavegacion.setLayout(new BoxLayout(panelNavegacion, BoxLayout.Y_AXIS));
        panelNavegacion.setPreferredSize(new Dimension(200, getHeight()));
        panelNavegacion.setBackground(Color.LIGHT_GRAY);

        panelCentral = new JPanel();
        cardLayout = new CardLayout();
        panelCentral.setLayout(cardLayout);

        btnGestionarUsuarios = new JButton("Gestionar Usuarios");
        btnGestionarPropiedades = new JButton("Gestionar Propiedades");
        btnGestionarAnimales = new JButton("Gestionar Animales");
        btnSalir = new JButton("Salir");

        if (usuario instanceof main.java.com.cappataz.modelo.Administrador) {
            panelNavegacion.add(btnGestionarUsuarios);
        }

        panelNavegacion.add(btnGestionarPropiedades);
        panelNavegacion.add(btnGestionarAnimales);
        panelNavegacion.add(Box.createVerticalGlue());
        panelNavegacion.add(btnSalir);

        for (Component component : panelNavegacion.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).setAlignmentX(Component.CENTER_ALIGNMENT);
                ((JButton) component).setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            }
        }

        add(panelNavegacion, BorderLayout.WEST);
        add(panelCentral, BorderLayout.CENTER);

        JPanel panelUsuarios = new JPanel();
        panelUsuarios.add(new JLabel("Gestión de Usuarios"));

        JPanel panelPropiedades = crearPanelPropiedades();

        JPanel panelAnimales = new JPanel();
        panelAnimales.add(new JLabel("Gestión de Animales"));

        panelCentral.add(panelUsuarios, "Usuarios");
        panelCentral.add(panelPropiedades, "Propiedades");
        panelCentral.add(panelAnimales, "Animales");

        if (usuario instanceof main.java.com.cappataz.modelo.Administrador) {
            btnGestionarUsuarios.addActionListener(e -> cardLayout.show(panelCentral, "Usuarios"));
        }

        btnGestionarPropiedades.addActionListener(e -> cardLayout.show(panelCentral, "Propiedades"));

        btnGestionarAnimales.addActionListener(e -> cardLayout.show(panelCentral, "Animales"));

        btnSalir.addActionListener(e -> System.exit(0));

        // Mostrar el panel de propiedades por defecto
        cardLayout.show(panelCentral, "Propiedades");
    }

    private JPanel crearPanelPropiedades() {
        PropiedadView propiedadView = new PropiedadView();
        PropiedadController propiedadController = new PropiedadController(propiedadView);
        propiedadController.cargarPropiedades();
        return propiedadView;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame(null).setVisible(true));
    }
}
