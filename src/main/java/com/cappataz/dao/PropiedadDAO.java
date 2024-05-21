package main.java.com.cappataz.dao;

import main.java.com.cappataz.modelo.Propiedad;
import main.java.com.cappataz.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropiedadDAO {

    public void savePropiedad(Propiedad propiedad) {
        String query = "INSERT INTO Propiedades (nombrePropiedad, ubicacion, superficie, tipoPropiedad, idPropietario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, propiedad.getNombrePropiedad());
            pstmt.setString(2, propiedad.getUbicacion());
            pstmt.setDouble(3, propiedad.getSuperficie());
            pstmt.setString(4, propiedad.getTipoPropiedad());
            pstmt.setInt(5, propiedad.getIdPropietario());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Propiedad> getAllPropiedades() {
        List<Propiedad> propiedades = new ArrayList<>();
        String query = "SELECT * FROM Propiedades";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Propiedad propiedad = new Propiedad(
                        rs.getInt("idPropiedad"),
                        rs.getString("nombrePropiedad"),
                        rs.getString("ubicacion"),
                        rs.getDouble("superficie"),
                        rs.getString("tipoPropiedad"),
                        rs.getDate("fechaRegistro"),
                        rs.getInt("idPropietario"));
                propiedades.add(propiedad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propiedades;
    }

    public Propiedad getPropiedadById(int idPropiedad) {
        Propiedad propiedad = null;
        String query = "SELECT * FROM Propiedades WHERE idPropiedad = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idPropiedad);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    propiedad = new Propiedad(
                            rs.getInt("idPropiedad"),
                            rs.getString("nombrePropiedad"),
                            rs.getString("ubicacion"),
                            rs.getDouble("superficie"),
                            rs.getString("tipoPropiedad"),
                            rs.getDate("fechaRegistro"),
                            rs.getInt("idPropietario"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propiedad;
    }
}
