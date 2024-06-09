package main.java.com.cappataz.dao;

import main.java.com.cappataz.modelo.EventoSanitario;
import main.java.com.cappataz.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoSanitarioDAO {
    public void saveEventoSanitario(EventoSanitario evento) {
        String query = "INSERT INTO eventos_sanitarios (idAnimal, idLote, fechaInicio, fechaFin, tratamiento, resultado, idCategoria, idOperario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, evento.getIdAnimal());
            pstmt.setInt(2, evento.getIdLote());
            pstmt.setDate(3, new Date(evento.getFechaInicio().getTime()));
            pstmt.setDate(4, new Date(evento.getFechaFin().getTime()));
            pstmt.setString(5, evento.getTratamiento());
            pstmt.setString(6, evento.getResultado());
            pstmt.setInt(7, evento.getIdCategoria());
            pstmt.setInt(8, evento.getIdOperario());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<EventoSanitario> getAllEventosSanitarios() {
        List<EventoSanitario> eventos = new ArrayList<>();
        String query = "SELECT * FROM eventos_sanitarios";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                EventoSanitario evento = new EventoSanitario();
                evento.setIdSanidad(rs.getInt("idSanidad"));
                evento.setIdAnimal(rs.getInt("idAnimal"));
                evento.setIdLote(rs.getInt("idLote"));
                evento.setFechaInicio(rs.getDate("fechaInicio"));
                evento.setFechaFin(rs.getDate("fechaFin"));
                evento.setTratamiento(rs.getString("tratamiento"));
                evento.setResultado(rs.getString("resultado"));
                evento.setIdCategoria(rs.getInt("idCategoria"));
                evento.setIdOperario(rs.getInt("idOperario"));
                eventos.add(evento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventos;
    }

    public List<EventoSanitario> getEventosSanitariosPorAnimal(int idAnimal) {
        List<EventoSanitario> eventos = new ArrayList<>();
        String query = "SELECT * FROM eventos_sanitarios WHERE idAnimal = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idAnimal);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    EventoSanitario evento = new EventoSanitario();
                    evento.setIdSanidad(rs.getInt("idSanidad"));
                    evento.setIdAnimal(rs.getInt("idAnimal"));
                    evento.setIdLote(rs.getInt("idLote"));
                    evento.setFechaInicio(rs.getDate("fechaInicio"));
                    evento.setFechaFin(rs.getDate("fechaFin"));
                    evento.setTratamiento(rs.getString("tratamiento"));
                    evento.setResultado(rs.getString("resultado"));
                    evento.setIdCategoria(rs.getInt("idCategoria"));
                    evento.setIdOperario(rs.getInt("idOperario"));
                    eventos.add(evento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventos;
    }

    public List<EventoSanitario> getEventosSanitariosPorLote(int idLote) {
        List<EventoSanitario> eventos = new ArrayList<>();
        String query = "SELECT * FROM eventos_sanitarios WHERE idLote = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idLote);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    EventoSanitario evento = new EventoSanitario();
                    evento.setIdSanidad(rs.getInt("idSanidad"));
                    evento.setIdAnimal(rs.getInt("idAnimal"));
                    evento.setIdLote(rs.getInt("idLote"));
                    evento.setFechaInicio(rs.getDate("fechaInicio"));
                    evento.setFechaFin(rs.getDate("fechaFin"));
                    evento.setTratamiento(rs.getString("tratamiento"));
                    evento.setResultado(rs.getString("resultado"));
                    evento.setIdCategoria(rs.getInt("idCategoria"));
                    evento.setIdOperario(rs.getInt("idOperario"));
                    eventos.add(evento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventos;
    }

    public EventoSanitario getEventoSanitarioById(int idSanidad) {
        EventoSanitario evento = null;
        String query = "SELECT * FROM eventos_sanitarios WHERE idSanidad = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idSanidad);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    evento = new EventoSanitario();
                    evento.setIdSanidad(rs.getInt("idSanidad"));
                    evento.setIdAnimal(rs.getInt("idAnimal"));
                    evento.setIdLote(rs.getInt("idLote"));
                    evento.setFechaInicio(rs.getDate("fechaInicio"));
                    evento.setFechaFin(rs.getDate("fechaFin"));
                    evento.setTratamiento(rs.getString("tratamiento"));
                    evento.setResultado(rs.getString("resultado"));
                    evento.setIdCategoria(rs.getInt("idCategoria"));
                    evento.setIdOperario(rs.getInt("idOperario"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evento;
    }

    public void updateEventoSanitario(EventoSanitario evento) {
        String query = "UPDATE eventos_sanitarios SET idAnimal = ?, idLote = ?, fechaInicio = ?, fechaFin = ?, tratamiento = ?, resultado = ?, idCategoria = ?, idOperario = ? WHERE idSanidad = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, evento.getIdAnimal());
            pstmt.setInt(2, evento.getIdLote());
            pstmt.setDate(3, new Date(evento.getFechaInicio().getTime()));
            pstmt.setDate(4, new Date(evento.getFechaFin().getTime()));
            pstmt.setString(5, evento.getTratamiento());
            pstmt.setString(6, evento.getResultado());
            pstmt.setInt(7, evento.getIdCategoria());
            pstmt.setInt(8, evento.getIdOperario());
            pstmt.setInt(9, evento.getIdSanidad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEventoSanitario(int idSanidad) {
        String query = "DELETE FROM eventos_sanitarios WHERE idSanidad = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idSanidad);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
