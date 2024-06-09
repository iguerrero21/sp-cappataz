package main.java.com.cappataz.dao;

import main.java.com.cappataz.modelo.Parcela;
import main.java.com.cappataz.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParcelaDAO {

    public void saveParcela(Parcela parcela) {
        String query = "INSERT INTO Parcelas (nombreParcela, ubicacion, superficie, uso, idPropiedad) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, parcela.getNombreParcela());
            pstmt.setString(2, parcela.getUbicacion());
            pstmt.setDouble(3, parcela.getSuperficie());
            pstmt.setString(4, parcela.getUso());
            pstmt.setInt(5, parcela.getIdPropiedad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar la parcela");
        }
    }

    public List<Parcela> getParcelasByPropiedad(int idPropiedad) {
        List<Parcela> parcelas = new ArrayList<>();
        String query = "SELECT * FROM Parcelas WHERE idPropiedad = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idPropiedad);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Parcela parcela = new Parcela(
                            rs.getInt("idParcela"),
                            rs.getString("nombreParcela"),
                            rs.getString("ubicacion"),
                            rs.getDouble("superficie"),
                            rs.getString("uso"),
                            rs.getInt("idPropiedad"));
                    parcelas.add(parcela);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las parcelas de la propiedad");
        }
        return parcelas;
    }

    public Parcela getParcelaById(int idParcela) {
        Parcela parcela = null;
        String query = "SELECT * FROM Parcelas WHERE idParcela = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idParcela);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    parcela = new Parcela(
                            rs.getInt("idParcela"),
                            rs.getString("nombreParcela"),
                            rs.getString("ubicacion"),
                            rs.getDouble("superficie"),
                            rs.getString("uso"),
                            rs.getInt("idPropiedad"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la parcela por ID");
        }
        return parcela;
    }
}
