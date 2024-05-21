package main.java.com.cappataz.dao;

import main.java.com.cappataz.modelo.Administrador;
import main.java.com.cappataz.modelo.Operario;
import main.java.com.cappataz.modelo.Propietario;
import main.java.com.cappataz.modelo.Usuario;
import main.java.com.cappataz.utils.DatabaseConnection;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public void saveUsuario(Usuario usuario) {
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

    public Usuario getUsuarioByEmailAndPassword(String email, String contrasena) {
        Usuario usuario = null;
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
}
