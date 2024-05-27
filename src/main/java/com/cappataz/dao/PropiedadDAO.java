
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

    public List<Object[]> getAllPropiedadesWithPropietario() {
        List<Object[]> propiedades = new ArrayList<>();
        String query = "SELECT p.idPropiedad, p.nombrePropiedad, p.ubicacion, p.superficie, p.tipoPropiedad, p.fechaRegistro, u.nombre AS nombrePropietario "
                +
                "FROM Propiedades p " +
                "JOIN Usuarios u ON p.idPropietario = u.idUsuario";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Object[] propiedad = {
                        rs.getInt("idPropiedad"),
                        rs.getString("nombrePropiedad"),
                        rs.getString("ubicacion"),
                        rs.getDouble("superficie"),
                        rs.getString("tipoPropiedad"),
                        rs.getDate("fechaRegistro"),
                        rs.getString("nombrePropietario")
                };
                propiedades.add(propiedad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propiedades;
    }
    
    public List<Object[]> getPropiedadesPaginated(int offset, int limit) {
        List<Object[]> propiedades = new ArrayList<>();
        String query = "SELECT p.idPropiedad AS id, p.nombrePropiedad, p.ubicacion, p.superficie, p.tipoPropiedad, p.fechaRegistro, CONCAT(u.nombre, ' ', u.apellido) AS Propietario "
                +
                "FROM Propiedades p " +
                "JOIN Usuarios u ON p.idPropietario = u.idUsuario " +
                "LIMIT ? OFFSET ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, limit);
            pstmt.setInt(2, offset);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Object[] propiedad = {
                            rs.getInt("id"),
                            rs.getString("nombrePropiedad"),
                            rs.getString("ubicacion"),
                            rs.getDouble("superficie"),
                            rs.getString("tipoPropiedad"),
                            rs.getDate("fechaRegistro"),
                            rs.getString("Propietario")
                    };
                    propiedades.add(propiedad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propiedades;
    }

    public List<Object[]> getPropiedadesByPropietario(int idPropietario) {
        List<Object[]> propiedades = new ArrayList<>();
        String query = "SELECT p.idPropiedad AS id, p.nombrePropiedad, p.ubicacion, p.superficie, p.tipoPropiedad, p.fechaRegistro, CONCAT(u.nombre, ' ', u.apellido) AS Propietario "
                +
                "FROM Propiedades p " +
                "JOIN Usuarios u ON p.idPropietario = u.idUsuario " +
                "WHERE p.idPropietario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idPropietario);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Object[] propiedad = {
                            rs.getInt("id"),
                            rs.getString("nombrePropiedad"),
                            rs.getString("ubicacion"),
                            rs.getDouble("superficie"),
                            rs.getString("tipoPropiedad"),
                            rs.getDate("fechaRegistro"),
                            rs.getString("Propietario")
                    };
                    propiedades.add(propiedad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propiedades;
    }

    public Object[] getPropiedadById(int idPropiedad) {
        Object[] propiedad = null;
        String query = "SELECT p.idPropiedad AS id, p.nombrePropiedad, p.ubicacion, p.superficie, p.tipoPropiedad, p.fechaRegistro, CONCAT(u.nombre, ' ', u.apellido) as Propietario "
                +
                "FROM Propiedades p " +
                "JOIN Usuarios u ON p.idPropietario = u.idUsuario " +
                "WHERE p.idPropiedad = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idPropiedad);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    propiedad = new Object[] {
                            rs.getInt("id"),
                            rs.getString("nombrePropiedad"),
                            rs.getString("ubicacion"),
                            rs.getDouble("superficie"),
                            rs.getString("tipoPropiedad"),
                            rs.getDate("fechaRegistro"),
                            rs.getString("Propietario")
                    };
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propiedad;
    }
}

// package main.java.com.cappataz.dao;

// import main.java.com.cappataz.modelo.Propiedad;
// import main.java.com.cappataz.util.DatabaseConnection;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;

// public class PropiedadDAO {

//     public void savePropiedad(Propiedad propiedad) {
//         String query = "INSERT INTO Propiedades (nombrePropiedad, ubicacion, superficie, tipoPropiedad, idPropietario) VALUES (?, ?, ?, ?, ?)";
//         try (Connection conn = DatabaseConnection.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setString(1, propiedad.getNombrePropiedad());
//             pstmt.setString(2, propiedad.getUbicacion());
//             pstmt.setDouble(3, propiedad.getSuperficie());
//             pstmt.setString(4, propiedad.getTipoPropiedad());
//             pstmt.setInt(5, propiedad.getIdPropietario());
//             pstmt.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public List<Object[]> getPropiedadesPaginated(int offset, int limit) {
//         List<Object[]> propiedades = new ArrayList<>();
//         String query = "SELECT p.idPropiedad, p.nombrePropiedad, p.ubicacion, p.superficie, p.tipoPropiedad, p.fechaRegistro, u.nombre AS nombrePropietario " +
//                        "FROM Propiedades p " +
//                        "JOIN Usuarios u ON p.idPropietario = u.idUsuario " +
//                        "LIMIT ? OFFSET ?";
//         try (Connection conn = DatabaseConnection.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setInt(1, limit);
//             pstmt.setInt(2, offset);
//             try (ResultSet rs = pstmt.executeQuery()) {
//                 while (rs.next()) {
//                     Object[] propiedad = {
//                             rs.getInt("idPropiedad"),
//                             rs.getString("nombrePropiedad"),
//                             rs.getString("ubicacion"),
//                             rs.getDouble("superficie"),
//                             rs.getString("tipoPropiedad"),
//                             rs.getDate("fechaRegistro"),
//                             rs.getString("nombrePropietario")
//                     };
//                     propiedades.add(propiedad);
//                 }
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return propiedades;
//     }

//     public List<Object[]> getPropiedadesByPropietario(int idPropietario) {
//         List<Object[]> propiedades = new ArrayList<>();
//         String query = "SELECT p.idPropiedad, p.nombrePropiedad, p.ubicacion, p.superficie, p.tipoPropiedad, p.fechaRegistro, u.nombre AS nombrePropietario " +
//                        "FROM Propiedades p " +
//                        "JOIN Usuarios u ON p.idPropietario = u.idUsuario " +
//                        "WHERE p.idPropietario = ?";
//         try (Connection conn = DatabaseConnection.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setInt(1, idPropietario);
//             try (ResultSet rs = pstmt.executeQuery()) {
//                 while (rs.next()) {
//                     Object[] propiedad = {
//                             rs.getInt("idPropiedad"),
//                             rs.getString("nombrePropiedad"),
//                             rs.getString("ubicacion"),
//                             rs.getDouble("superficie"),
//                             rs.getString("tipoPropiedad"),
//                             rs.getDate("fechaRegistro"),
//                             rs.getString("nombrePropietario")
//                     };
//                     propiedades.add(propiedad);
//                 }
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return propiedades;
//     }

//     public Object[] getPropiedadById(int idPropiedad) {
//         Object[] propiedad = null;
//         String query = "SELECT p.idPropiedad, p.nombrePropiedad, p.ubicacion, p.superficie, p.tipoPropiedad, p.fechaRegistro, u.nombre as nombrePropietario " +
//                        "FROM Propiedades p " +
//                        "JOIN Usuarios u ON p.idPropietario = u.idUsuario " +
//                        "WHERE p.idPropiedad = ?";
//         try (Connection conn = DatabaseConnection.getConnection();
//              PreparedStatement pstmt = conn.prepareStatement(query)) {
//             pstmt.setInt(1, idPropiedad);
//             try (ResultSet rs = pstmt.executeQuery()) {
//                 if (rs.next()) {
//                     propiedad = new Object[]{
//                             rs.getInt("idPropiedad"),
//                             rs.getString("nombrePropiedad"),
//                             rs.getString("ubicacion"),
//                             rs.getDouble("superficie"),
//                             rs.getString("tipoPropiedad"),
//                             rs.getDate("fechaRegistro"),
//                             rs.getString("nombrePropietario")
//                     };
//                 }
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return propiedad;
//     }
// }
