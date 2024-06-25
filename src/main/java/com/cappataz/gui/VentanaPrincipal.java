package main.java.com.cappataz.gui;

import main.java.com.cappataz.modelo.Administrador;
import main.java.com.cappataz.modelo.IUsuario;
import main.java.com.cappataz.modelo.Operario;
import main.java.com.cappataz.modelo.Propietario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private IUsuario usuario;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemGestionarUsuarios;
    private JMenuItem menuItemGestionarPropiedades;
    private JMenuItem menuItemGestionarAnimales;
    private JMenuItem menuItemSalir;

    private JButton btnGestionarUsuarios;
    private JButton btnGestionarPropiedades;
    private JButton btnGestionarAnimales;
    private JButton btnSalir;

    public VentanaPrincipal(IUsuario usuario) {
        this.usuario = usuario;

        // Configuración de la ventana principal
        setTitle("Sistema de Gestión Ganadera");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear barra de menú
        menuBar = new JMenuBar();

        // Crear menú
        menu = new JMenu("Menú");
        menuBar.add(menu);

        // Crear ítems de menú
        menuItemGestionarUsuarios = new JMenuItem("Gestionar Usuarios");
        menuItemGestionarPropiedades = new JMenuItem("Gestionar Propiedades");
        menuItemGestionarAnimales = new JMenuItem("Gestionar Animales");
        menuItemSalir = new JMenuItem("Salir");

        // Agregar ítems de menú al menú
        if (usuario instanceof Administrador) {
            menu.add(menuItemGestionarUsuarios);
        }
        menu.add(menuItemGestionarPropiedades);
        menu.add(menuItemGestionarAnimales);
        menu.addSeparator();
        menu.add(menuItemSalir);

        // Agregar barra de menú a la ventana
        setJMenuBar(menuBar);

        // Crear botones
        JPanel panelBotones = new JPanel(new GridLayout(4, 1));
        btnGestionarUsuarios = new JButton("Gestionar Usuarios");
        btnGestionarPropiedades = new JButton("Gestionar Propiedades");
        btnGestionarAnimales = new JButton("Gestionar Animales");
        btnSalir = new JButton("Salir");

        if (usuario instanceof Administrador) {
            panelBotones.add(btnGestionarUsuarios);
        }
        panelBotones.add(btnGestionarPropiedades);
        panelBotones.add(btnGestionarAnimales);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.CENTER);

        // Agregar listeners a los ítems de menú
        if (usuario instanceof Administrador) {
            menuItemGestionarUsuarios.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new GestionarUsuariosFrame().setVisible(true);
                }
            });

            btnGestionarUsuarios.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new GestionarUsuariosFrame().setVisible(true);
                }
            });
        }

        menuItemGestionarPropiedades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para gestionar propiedades
                // Aquí se puede abrir una nueva ventana o diálogo para gestionar propiedades
            }
        });

        btnGestionarPropiedades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para gestionar propiedades
                // Aquí se puede abrir una nueva ventana o diálogo para gestionar propiedades
            }
        });

        menuItemGestionarAnimales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para gestionar animales
                // Aquí se puede abrir una nueva ventana o diálogo para gestionar animales
            }
        });

        btnGestionarAnimales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para gestionar animales
                // Aquí se puede abrir una nueva ventana o diálogo para gestionar animales
            }
        });

        menuItemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Se debería inicializar con un usuario real
                new VentanaPrincipal(null).setVisible(true);
            }
        });
    }
}
