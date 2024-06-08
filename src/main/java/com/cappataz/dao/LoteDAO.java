package main.java.com.cappataz.dao;

import main.java.com.cappataz.modelo.Animal;
import main.java.com.cappataz.modelo.Lote;
import main.java.com.cappataz.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoteDAO {

    public List<Lote> getAllLotes() {
        List<Lote> lotes = new ArrayList<>();
        String query = "SELECT Lotes.idLote, Lotes.nombreLote, Lotes.idParcela, Lotes.idPropietario, Lotes.fechaCreacion, "
                +
                "COUNT(Animales.idAnimal) AS cantidadAnimales, Categorias.nombreCategoria AS categoria, " +
                "CONCAT(usuarios.nombre, ' ', usuarios.apellido) AS nombrePropietario, Propiedades.nombrePropiedad AS nombrePropiedad, Parcelas.nombreParcela AS nombreParcela "
                +
                "FROM Lotes " +
                "LEFT JOIN Animales ON Lotes.idLote = Animales.idLote " +
                "LEFT JOIN Categorias ON Animales.idCategoria = Categorias.idCategoria " +
                "LEFT JOIN Usuarios ON Lotes.idPropietario = Usuarios.idUsuario AND Usuarios.idRol = 2 " + // Filtrar
                                                                                                           // propietarios
                "LEFT JOIN Parcelas ON Lotes.idParcela = Parcelas.idParcela " +
                "LEFT JOIN Propiedades ON Parcelas.idPropiedad = Propiedades.idPropiedad " +
                "GROUP BY Lotes.idLote, Categorias.nombreCategoria, nombrePropietario, nombrePropiedad, nombreParcela";

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
        }
        return lotes;
    }

    public Lote getLoteById(int idLote) {
        Lote lote = null;
        String query = "SELECT * FROM Lotes WHERE idLote = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idLote);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                lote = new Lote(
                        rs.getInt("idLote"),
                        rs.getString("nombreLote"),
                        rs.getInt("idPropietario"),
                        rs.getInt("idParcela"),
                        rs.getDate("fechaCreacion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lote;
    }

    public void saveLote(Lote lote) {
        String query = "INSERT INTO Lotes (nombreLote, idParcela, idPropietario) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, lote.getNombre());
            pstmt.setInt(2, lote.getIdParcela());
            pstmt.setInt(3, lote.getIdPropietario());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLote(Lote lote) {
        String query = "UPDATE Lotes SET nombreLote = ?, idParcela = ?, idPropietario = ? WHERE idLote = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, lote.getNombre());
            pstmt.setInt(2, lote.getIdParcela());
            pstmt.setInt(3, lote.getIdPropietario());
            pstmt.setInt(4, lote.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
        }
    }

    // public List<Animal> getAnimalesPorLote(int idLote) {
    //     List<Animal> animals = new ArrayList<>();
    //     String query = "SELECT * FROM animales WHERE idLote = ?";
    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement pstmt = conn.prepareStatement(query)) {

    //         pstmt.setInt(1, idLote);
    //         ResultSet rs = pstmt.executeQuery();
    //         while (rs.next()) {
    //             Animal animal = new Animal();
    //             animal.setId(rs.getInt("idAnimal"));
    //             animal.setTagId(rs.getString("tagIdentificacion"));
    //             animal.setTagRFID(rs.getString("tagRFID"));
    //             animal.setEspecie(rs.getString("especie"));
    //             animal.setRaza(rs.getString("raza"));
    //             animal.setFechaNac(rs.getDate("fechaNacimiento"));
    //             animal.setSexo(rs.getString("sexo").charAt(0));
    //             animal.setCastrado(rs.getBoolean("castrado"));
    //             animal.setIdCategoria(rs.getInt("idCategoria"));
    //             animal.setIdLote(rs.getInt("idLote"));
    //             animal.setIdPropietario(rs.getInt("idPropietario"));
    //             animals.add(animal);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return animals;
    // }

}
