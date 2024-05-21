// package main.java.com.cappataz.utils;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class ConexionMySQL {
//     public static void main(String[] args) {
//         // URL de conexión a la base de datos
//         String url = "jdbc:mysql://localhost:3306/sc_cappataz?serverTimezone=UTC";

//         // Credenciales de la base de datos
//         String username = "root";
//         String password = "VINF012729";

//         try {
//             // Cargando el driver
//             Class.forName("com.mysql.cj.jdbc.Driver");

//             // Estableciendo la conexión
//             Connection connection = DriverManager.getConnection(url, username, password);

//             if (connection != null) {
//                 System.out.println("Conectado a la base de datos");
//                 // Aquí puedes realizar operaciones con la base de datos
//             }

//             // Cerrar la conexión
//             connection.close();
//         } catch (SQLException e) {
//             System.out.println("Error de SQL: " + e.getMessage());
//         } catch (ClassNotFoundException e) {
//             System.out.println("No se encontró el driver JDBC: " + e.getMessage());
//         }
//     }
// }
