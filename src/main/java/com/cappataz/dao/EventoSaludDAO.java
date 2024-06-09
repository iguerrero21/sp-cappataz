package main.java.com.cappataz.dao;

import main.java.com.cappataz.modelo.EventoSanitario;
import main.java.com.cappataz.modelo.EventoSalud;
import main.java.com.cappataz.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EventoSaludDAO {
    public void saveEventoSalud(EventoSalud evento) {
        String query = "INSERT INTO EventosSalud (idAnimal, fecha, enfermedad, tratamiento, idOperario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, evento.getIdAnimal());
            pstmt.setDate(2, new java.sql.Date(evento.getFecha().getTime()));
            pstmt.setString(3, evento.getEnfermedad());
            pstmt.setString(4, evento.getTratamiento());
            pstmt.setInt(5, evento.getIdOperario());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos como update, delete, get, etc.
}
