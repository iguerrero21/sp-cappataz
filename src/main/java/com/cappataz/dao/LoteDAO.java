package main.java.com.cappataz.dao;

import main.java.com.cappataz.modelo.Lote;
import main.java.com.cappataz.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoteDAO {

    public void saveLote(Lote lote) {
        String query = "INSERT INTO Lotes (nombreLote, idPropietario, idParcela, fechaCreacion) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, lote.getNombre());
            pstmt.setInt(2, lote.getIdPropietario());
            pstmt.setInt(3, lote.getIdParcela());
            pstmt.setDate(4, new Date(System.currentTimeMillis()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar el lote");
        }
    }

    public List<Lote> getAllLotes() {
        List<Lote> lotes = new ArrayList<>();
        String query = "SELECT l.*, COUNT(a.idAnimal) AS cantidadAnimales, c.nombreCategoria AS categoria, "
                + "CONCAT(p.nombre, ' ', p.apellido) AS nombrePropietario, pr.nombrePropiedad AS nombrePropiedad, "
                + "pa.nombreParcela AS nombreParcela "
                + "FROM Lotes l "
                + "LEFT JOIN Animales a ON l.idLote = a.idLote "
                + "LEFT JOIN Categorias c ON a.idCategoria = c.idCategoria "
                + "LEFT JOIN Usuarios p ON l.idPropietario = p.idUsuario "
                + "LEFT JOIN Parcelas pa ON l.idParcela = pa.idParcela "
                + "LEFT JOIN Propiedades pr ON pa.idPropiedad = pr.idPropiedad "
                + "GROUP BY l.idLote";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Lote lote = new Lote(
                        rs.getInt("idLote"),
                        rs.getString("nombreLote"),
                        rs.getInt("idPropietario"),
                        rs.getInt("idParcela"),
                        rs.getDate("fechaCreacion"));
                lote.setCantidadAnimales(rs.getInt("cantidadAnimales"));
                lote.setCategoria(rs.getString("categoria"));
                lote.setNombrePropietario(rs.getString("nombrePropietario"));
                lote.setNombrePropiedad(rs.getString("nombrePropiedad"));
                lote.setNombreParcela(rs.getString("nombreParcela"));
                lotes.add(lote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los lotes");
        }
        return lotes;
    }

    public Lote getLoteById(int idLote) {
        Lote lote = null;
        String query = "SELECT l.*, COUNT(a.idAnimal) AS cantidadAnimales, c.nombre AS categoria, "
                + "CONCAT(p.nombre, ' ', p.apellido) AS nombrePropietario, pr.nombre AS nombrePropiedad, "
                + "pa.nombre AS nombreParcela "
                + "FROM Lotes l "
                + "LEFT JOIN Animales a ON l.idLote = a.idLote "
                + "LEFT JOIN Categorias c ON a.idCategoria = c.idCategoria "
                + "LEFT JOIN Usuarios p ON l.idPropietario = p.idUsuario "
                + "LEFT JOIN Propiedades pr ON l.idPropiedad = pr.idPropiedad "
                + "LEFT JOIN Parcelas pa ON l.idParcela = pa.idParcela "
                + "WHERE l.idLote = ? "
                + "GROUP BY l.idLote";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idLote);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    lote = new Lote(
                            rs.getInt("idLote"),
                            rs.getString("nombreLote"),
                            rs.getInt("idPropietario"),
                            rs.getInt("idParcela"),
                            rs.getDate("fechaCreacion"));
                    lote.setCantidadAnimales(rs.getInt("cantidadAnimales"));
                    lote.setCategoria(rs.getString("categoria"));
                    lote.setNombrePropietario(rs.getString("nombrePropietario"));
                    lote.setNombrePropiedad(rs.getString("nombrePropiedad"));
                    lote.setNombreParcela(rs.getString("nombreParcela"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el lote");
        }
        return lote;
    }

    public void updateLote(Lote lote) {
        String query = "UPDATE Lotes SET nombreLote = ?, idPropietario = ?, idParcela = ? WHERE idLote = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, lote.getNombre());
            pstmt.setInt(2, lote.getIdPropietario());
            pstmt.setInt(3, lote.getIdParcela());
            pstmt.setInt(4, lote.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el lote");
        }
    }

    public void deleteLote(int idLote) {
        String query = "DELETE FROM Lotes WHERE idLote = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idLote);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el lote");
        }
    }
}
