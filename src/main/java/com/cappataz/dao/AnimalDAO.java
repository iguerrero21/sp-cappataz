package main.java.com.cappataz.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.cappataz.modelo.Animal;
import main.java.com.cappataz.util.DatabaseConnection;

public class AnimalDAO {
    public void saveAnimal(Animal animal) {
        String query = "INSERT INTO animales (idAnimal, tagIdentificacion, tagRFID, especie, raza, fechaNacimiento, sexo, castrado, idCategoria, idLote, idPropietario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, animal.getId());
            pstmt.setString(2, animal.getTagId());
            pstmt.setString(3, animal.getTagRFID());
            pstmt.setString(4, animal.getEspecie());
            pstmt.setString(5, animal.getRaza());
            pstmt.setDate(6, (Date) animal.getFechaNac());
            pstmt.setString(7, animal.getSexo().toString());
            pstmt.setBoolean(8, animal.getCastrado());
            pstmt.setInt(9, animal.getIdCategoria());
            pstmt.setInt(10, animal.getIdLote());
            pstmt.setInt(11, animal.getIdPropietario());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al guardar el animal: " + e.getMessage());
        }
    }

    public List<Animal> getAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        String query = "SELECT * FROM animales";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getInt("idAnimal"));
                animal.setTagId(rs.getString("tagIdentificacion"));
                animal.setTagRFID(rs.getString("tagRFID"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaza(rs.getString("raza"));
                animal.setFechaNac(rs.getDate("fechaNacimiento"));
                animal.setSexo(rs.getString("sexo").charAt(0));
                animal.setCastrado(rs.getBoolean("castrado"));
                animal.setIdCategoria(rs.getInt("idCategoria"));
                animal.setIdLote(rs.getInt("idLote"));
                animal.setIdPropietario(rs.getInt("idPropietario"));
                animals.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener los animales: " + e.getMessage());
        }
        return animals;
    }

    public Animal getAnimalById(int id) {
        Animal animal = null;
        String query = "SELECT * FROM animales WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                animal = new Animal();
                animal.setId(rs.getInt("idAnimal"));
                animal.setTagId(rs.getString("tagIdentificacion"));
                animal.setTagRFID(rs.getString("tagRFID"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaza(rs.getString("raza"));
                animal.setFechaNac(rs.getDate("fechaNacimiento"));
                animal.setSexo(rs.getString("sexo").charAt(0));
                animal.setCastrado(rs.getBoolean("castrado"));
                animal.setIdCategoria(rs.getInt("idCategoria"));
                animal.setIdLote(rs.getInt("idLote"));
                animal.setIdPropietario(rs.getInt("idPropietario"));
            }
            rs.close();
            } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener el animal: " + e.getMessage());
        }
        return animal;
    }

    public List<Animal> getAnimalesPorPropietario(int idPropietario) {
        List<Animal> animals = new ArrayList<>();
        String query = "SELECT * FROM animales WHERE idPropietario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idPropietario);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getInt("idAnimal"));
                animal.setTagId(rs.getString("tagIdentificacion"));
                animal.setTagRFID(rs.getString("tagRFID"));
                animal.setEspecie(rs.getString("especie"));
                animal.setFechaNac(rs.getDate("fechaNacimiento"));
                animal.setSexo(rs.getString("sexo").charAt(0));
                animal.setRaza(rs.getString("raza"));
                animal.setCastrado(rs.getBoolean("castrado"));
                animal.setIdCategoria(rs.getInt("idCategoria"));
                animal.setIdLote(rs.getInt("idLote"));
                animal.setIdPropietario(rs.getInt("idPropietario"));
                animals.add(animal);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener los animales: " + e.getMessage());
        }
        return animals;
    }

    public List<Animal> getAnimalesPorLote(int idLote) {
        List<Animal> animals = new ArrayList<>();
        String query = "SELECT Animales.*, Categorias.nombreCategoria AS nombreCategoria, CONCAT(usuarios.nombre, ' ', usuarios.apellido) AS nombrePropietario "
                +
                "FROM Animales " +
                "LEFT JOIN Categorias ON Animales.idCategoria = Categorias.idCategoria " +
                "LEFT JOIN Usuarios ON Animales.idPropietario = Usuarios.idUsuario " +
                "WHERE Animales.idLote = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idLote);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getInt("idAnimal"));
                animal.setTagId(rs.getString("tagIdentificacion"));
                animal.setTagRFID(rs.getString("tagRFID"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaza(rs.getString("raza"));
                animal.setFechaNac(rs.getDate("fechaNacimiento"));
                animal.setSexo(rs.getString("sexo").charAt(0));
                animal.setCastrado(rs.getBoolean("castrado"));
                animal.setIdCategoria(rs.getInt("idCategoria"));
                animal.setIdLote(rs.getInt("idLote"));
                animal.setIdPropietario(rs.getInt("idPropietario"));
                animal.setNombreCategoria(rs.getString("nombreCategoria"));
                animal.setNombrePropietario(rs.getString("nombrePropietario"));
                animals.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error en la carga: " + e.getMessage());
        }
        return animals;
    }
}
