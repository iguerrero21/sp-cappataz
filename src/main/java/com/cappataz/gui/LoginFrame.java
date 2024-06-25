package main.java.com.cappataz.gui;

import main.java.com.cappataz.controlador.UsuarioController;
import main.java.com.cappataz.modelo.IUsuario;
import main.java.com.cappataz.vista.UsuarioView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("Login");
        setSize(400, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel emailLabel = new JLabel("Email:");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        panel.add(emailLabel, c);

        emailField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(emailField, c);

        JLabel passwordLabel = new JLabel("Contraseña:");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        panel.add(passwordLabel, c);

        passwordField = new JPasswordField(20);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        panel.add(passwordField, c);

        btnLogin = new JButton("Login");
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        panel.add(btnLogin, c);

        add(panel);

        getRootPane().setDefaultButton(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioView usuarioView = new UsuarioView();
                UsuarioController usuarioController = new UsuarioController(null, usuarioView);
                IUsuario usuario = usuarioController.login(emailField.getText(),
                        new String(passwordField.getPassword()));
                if (usuario != null) {
                    new MainFrame(usuario).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "Email o contraseña incorrectos. Inténtelo de nuevo.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
