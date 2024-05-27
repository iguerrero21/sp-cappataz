package main.java.com.cappataz.dao;

import main.java.com.cappataz.modelo.Administrador;
import main.java.com.cappataz.modelo.Operario;
import main.java.com.cappataz.modelo.Propietario;
import main.java.com.cappataz.modelo.IUsuario;
import main.java.com.cappataz.util.DatabaseConnection;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void saveUsuario(IUsuario usuario) {
        String query = "INSERT INTO Usuarios (nombre, apellido, email, contrasena, idRol) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, hashPassword(usuario.getContrasena()));
            pstmt.setInt(5, usuario.getIdRol());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public IUsuario getUsuarioByEmailAndPassword(String email, String contrasena) {
        IUsuario usuario = null;
        String query = "SELECT * FROM Usuarios WHERE email = ? AND contrasena = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            String hashedPassword = hashPassword(contrasena);
            pstmt.setString(1, email);
            pstmt.setString(2, hashedPassword);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int idRol = rs.getInt("idRol");
                    switch (idRol) {
                        case 1:
                            usuario = new Administrador(
                                    rs.getInt("idUsuario"),
                                    rs.getString("nombre"),
                                    rs.getString("apellido"),
                                    rs.getString("email"),
                                    rs.getString("contrasena")
                            );
                            break;
                        case 2:
                            usuario = new Propietario(
                                    rs.getInt("idUsuario"),
                                    rs.getString("nombre"),
                                    rs.getString("apellido"),
                                    rs.getString("email"),
                                    rs.getString("contrasena")
                            );
                            break;
                        case 3:
                            usuario = new Operario(
                                    rs.getInt("idUsuario"),
                                    rs.getString("nombre"),
                                    rs.getString("apellido"),
                                    rs.getString("email"),
                                    rs.getString("contrasena")
                            );
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Propietario> getPropietarios() {
        List<Propietario> propietarios = new ArrayList<>();
        String query = "SELECT idUsuario, nombre, apellido, email, contrasena FROM Usuarios WHERE idRol = 2";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Propietario propietario = new Propietario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("contrasena"));
                propietarios.add(propietario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propietarios;
    }
}
