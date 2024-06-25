package main.java.com.cappataz.gui;

import javax.swing.*;

public class PanelGestionarAnimales extends JPanel {
    public PanelGestionarAnimales() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Gestionar Animales"));
        // Aquí puedes agregar más componentes específicos para la gestión de animales
    }
}
