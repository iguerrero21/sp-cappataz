package main.java.com.cappataz.gui;

import javax.swing.*;

public class PanelGestionarUsuarios extends JPanel {
    public PanelGestionarUsuarios() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Gestionar Usuarios"));
        // Aquí puedes agregar más componentes específicos para la gestión de usuarios
    }
}
