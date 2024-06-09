package main.java.com.cappataz.dao;

import main.java.com.cappataz.modelo.Administrador;
import main.java.com.cappataz.modelo.Operario;
import main.java.com.cappataz.modelo.Propietario;
import main.java.com.cappataz.modelo.IUsuario;
import main.java.com.cappataz.util.DatabaseConnection;
import main.java.com.cappataz.util.HashGenerator;

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
            pstmt.setString(4, HashGenerator.hashPassword(usuario.getContrasena()));
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
            String hashedPassword = HashGenerator.hashPassword(contrasena);
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
                                    rs.getString("contrasena"));
                            break;
                        case 2:
                            usuario = new Propietario(
                                    rs.getInt("idUsuario"),
                                    rs.getString("nombre"),
                                    rs.getString("apellido"),
                                    rs.getString("email"),
                                    rs.getString("contrasena"));
                            break;
                        case 3:
                            usuario = new Operario(
                                    rs.getInt("idUsuario"),
                                    rs.getString("nombre"),
                                    rs.getString("apellido"),
                                    rs.getString("email"),
                                    rs.getString("contrasena"));
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<IUsuario> getAllUsuarios() {
        List<IUsuario> usuarios = new ArrayList<>();
        String query = "SELECT idUsuario, nombre, apellido, email, idRol FROM Usuarios";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int idRol = rs.getInt("idRol");
                IUsuario usuario = null;
                switch (idRol) {
                    case 1:
                        usuario = new Administrador(
                                rs.getInt("idUsuario"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getString("email"),
                                null); // No se recupera la contraseña
                        break;
                    case 2:
                        usuario = new Propietario(
                                rs.getInt("idUsuario"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getString("email"),
                                null); // No se recupera la contraseña
                        break;
                    case 3:
                        usuario = new Operario(
                                rs.getInt("idUsuario"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getString("email"),
                                null); // No se recupera la contraseña
                        break;
                }
                if (usuario != null) {
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public List<IUsuario> getUsuariosByRole(int roleId) {
        List<IUsuario> usuarios = new ArrayList<>();
        String query = "SELECT idUsuario, nombre, apellido, email, idRol FROM Usuarios WHERE idRol = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, roleId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int idRol = rs.getInt("idRol");
                    IUsuario usuario = null;
                    switch (idRol) {
                        case 1:
                            usuario = new Administrador(
                                    rs.getInt("idUsuario"),
                                    rs.getString("nombre"),
                                    rs.getString("apellido"),
                                    rs.getString("email"),
                                    null); // No se recupera la contraseña
                            break;
                        case 2:
                            usuario = new Propietario(
                                    rs.getInt("idUsuario"),
                                    rs.getString("nombre"),
                                    rs.getString("apellido"),
                                    rs.getString("email"),
                                    null); // No se recupera la contraseña
                            break;
                        case 3:
                            usuario = new Operario(
                                    rs.getInt("idUsuario"),
                                    rs.getString("nombre"),
                                    rs.getString("apellido"),
                                    rs.getString("email"),
                                    null); // No se recupera la contraseña
                            break;
                    }
                    if (usuario != null) {
                        usuarios.add(usuario);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public List<Propietario> getPropietarios() {
        List<Propietario> propietarios = new ArrayList<>();
        String query = "SELECT DISTINCT idUsuario, nombre, apellido, email FROM Usuarios WHERE idRol = 2";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Propietario propietario = new Propietario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        null); // No se recupera la contraseña
                propietarios.add(propietario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propietarios;
    }

    public Propietario getPropietarioById(int idPropietario) {
        Propietario propietario = null;
        String query = "SELECT * FROM Usuarios WHERE idUsuario = ? AND idRol = 2";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idPropietario);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    propietario = new Propietario(
                            rs.getInt("idUsuario"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("email"),
                            null); // No se recupera la contraseña
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propietario;
    }

    public Operario getOperarioById(int idOperario) {
        Operario operario = null;
        String query = "SELECT * FROM Usuarios WHERE idUsuario = ? AND idRol = 3";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idOperario);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    operario = new Operario(
                            rs.getInt("idUsuario"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("email"),
                            null); // No se recupera la contraseña
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operario;
    }

    public void deleteUsuario(int idUsuario) {
        String query = "DELETE FROM Usuarios WHERE idUsuario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idUsuario);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
