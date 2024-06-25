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
            throw new RuntimeException("Error al guardar la propiedad");
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
            throw new RuntimeException("Error al obtener las propiedades");
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
            throw new RuntimeException("Error al obtener la propiedad");
        }
        return propiedad;
    }

    public List<Propiedad> getPropiedadesPaginated(int offset, int limit) {
        List<Propiedad> propiedades = new ArrayList<>();
        String query = "SELECT * FROM Propiedades LIMIT ? OFFSET ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, limit);
            pstmt.setInt(2, offset);
            try (ResultSet rs = pstmt.executeQuery()) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las propiedades paginadas");
        }
        return propiedades;
    }

    public List<Propiedad> getPropiedadesByPropietario(int idPropietario) {
        List<Propiedad> propiedades = new ArrayList<>();
        String query = "SELECT * FROM Propiedades WHERE idPropietario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idPropietario);
            try (ResultSet rs = pstmt.executeQuery()) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las propiedades del propietario");
        }
        return propiedades;
    }

    public void updatePropiedad(Propiedad propiedad) {
        String query = "UPDATE Propiedades SET nombrePropiedad = ?, ubicacion = ?, superficie = ?, tipoPropiedad = ?, idPropietario = ? WHERE idPropiedad = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, propiedad.getNombrePropiedad());
            pstmt.setString(2, propiedad.getUbicacion());
            pstmt.setDouble(3, propiedad.getSuperficie());
            pstmt.setString(4, propiedad.getTipoPropiedad());
            pstmt.setInt(5, propiedad.getIdPropietario());
            pstmt.setInt(6, propiedad.getIdPropiedad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar la propiedad");
        }
    }

    public void deletePropiedad(int idPropiedad) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Borrar parcelas asociadas a la propiedad
            String deleteParcelasQuery = "DELETE FROM Parcelas WHERE idPropiedad = ?";
            try (PreparedStatement pstmtParcelas = conn.prepareStatement(deleteParcelasQuery)) {
                pstmtParcelas.setInt(1, idPropiedad);
                pstmtParcelas.executeUpdate();
            }

            // Mover animales a un lote desconocido
            String updateAnimalesQuery = "UPDATE Animales SET idLote = (SELECT idLote FROM Lotes WHERE nombreLote = 'Desconocido') WHERE idLote IN (SELECT idLote FROM Lotes WHERE idPropiedad = ?)";
            try (PreparedStatement pstmtAnimales = conn.prepareStatement(updateAnimalesQuery)) {
                pstmtAnimales.setInt(1, idPropiedad);
                pstmtAnimales.executeUpdate();
            }

            // Borrar lotes asociados a la propiedad
            String deleteLotesQuery = "DELETE FROM Lotes WHERE idPropiedad = ?";
            try (PreparedStatement pstmtLotes = conn.prepareStatement(deleteLotesQuery)) {
                pstmtLotes.setInt(1, idPropiedad);
                pstmtLotes.executeUpdate();
            }

            // Borrar la propiedad
            String deletePropiedadQuery = "DELETE FROM Propiedades WHERE idPropiedad = ?";
            try (PreparedStatement pstmtPropiedad = conn.prepareStatement(deletePropiedadQuery)) {
                pstmtPropiedad.setInt(1, idPropiedad);
                pstmtPropiedad.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
